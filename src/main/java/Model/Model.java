package Model;

import Entities.ObligationServiceTask;
import Entities.ObligationTimerTask;
import Entities.Party;
import Entities.Service;
import GUI.GUI;
import gen.FACTLexer;
import gen.FACTParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Model {
    private static final String connectionUrl = "jdbc:sqlserver://localhost:5555;database=FactDB;integratedSecurity=true;";

    private HashMap<String, String> templates = new HashMap<>();

    private Connection connection;
    private Statement statement;

    private GUI view;
    private String contract = "";

    private int seconds = 0;
    private ArrayList<Party> parties = new ArrayList<>();
    private Timer timer;

    private List<ObligationServiceTask> obligationServiceTasks = new ArrayList<>();

    public Model() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(connectionUrl);
            this.statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE parties;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setView(GUI view) {
        this.view = view;
    }

    public void updateParties() {
        parties.clear();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM parties");
            while (rs.next()) {
                parties.add(new Party(rs.getString("party_name"), rs.getInt("amount")));
            }
            view.setParties(parties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEvent(Service service) {
        HashMap<String, Boolean> properties = new HashMap<>();
        for (String p : service.getProperties()) {
            properties.put(p, false);
        }
        view.addEvent(service.getServiceName(), properties, () -> {
            startEvent(service.getServiceName(), properties, service.getTerm());
        });
    }

    public void runContract(String contract) {
        this.contract = contract;

        FACTLexer lexer = new FACTLexer(CharStreams.fromString(contract));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        FACTParser parser = new FACTParser(tokenStream);

        ParseTree tree = parser.contract();
        ParseTreeWalker walker = new ParseTreeWalker();
        FACTWalker factWalker = new FACTWalker();
        factWalker.setModel(this);
        walker.walk(factWalker, tree);

        if (!factWalker.getErrorMessage().equals("")) {
            view.showContractIncorrect(factWalker.getErrorMessage());
            return;
        }

        try {
            for (Party p : factWalker.getParties()) {
                String sql = "INSERT parties VALUES ('" + p.getName() + "', " + p.getAmount() + ")";
                statement.executeUpdate(sql);
            }
            updateParties();

            for (ObligationTimerTask obligation : factWalker.getObligationTimerTasks()) {
                obligation.setConnection(connection);
                if (obligation.getTerm() > 0) {
                    timer = new Timer(true);
                    timer.schedule(obligation, obligation.getTerm() * 1000);

                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            seconds++;
                            view.updateTime(seconds);
                        }
                    }, 1000, 1000);
                }
            }

            for (ObligationServiceTask obligation : factWalker.getObligationServiceTasks()) {
                obligation.setConnection(connection);
                obligationServiceTasks.add(obligation);
                if (obligation.getService().getTerm() > 0) {
                    timer = new Timer(true);

                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            seconds++;
                            view.updateTime(seconds);
                        }
                    }, 1000, 1000);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startEvent(String eventName, HashMap<String, Boolean> properties, int term) {
        if (term > 0 && seconds > term) { return; }
        for (Map.Entry<String, Boolean> p : properties.entrySet()) {
            if (!p.getValue()) { return; }
        }
        for (ObligationServiceTask obligation : obligationServiceTasks) {
            if (obligation.getService().getServiceName().equals(eventName)) {
                obligation.run();
                return;
            }
        }
    }

    public void stopContract() {
        try {
            statement.executeUpdate("TRUNCATE TABLE parties;");
            if (timer != null) timer.cancel();
            parties.clear();
            obligationServiceTasks.clear();
            seconds = 0;
            view.clearData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addText(String str) {
        view.addText(str);
    }

    public void addEditField(String str) {
        view.addEditField(str);
    }
}
