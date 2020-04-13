package Entities;

import Model.Model;

import java.util.TimerTask;
import java.sql.*;

public class ObligationTimerTask extends TimerTask {
    private Model model;

    private Party debtor;
    private Party creditor;

    private Subject subject;
    private int term;

    private Connection connection;

    public ObligationTimerTask(Model model, Party debtor, Party creditor, Subject subject, int term) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.subject = subject;
        this.term = term;
        this.model = model;
    }

    public Party getDebtor() {
        return debtor;
    }

    public void setDebtor(Party debtor) {
        this.debtor = debtor;
    }

    public Party getCreditor() {
        return creditor;
    }

    public void setCreditor(Party creditor) {
        this.creditor = creditor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        if (connection == null) { return; }
        if (subject == Subject.AMOUNT) {
            debtor.setAmount(debtor.getAmount() - subject.getAmount());
            creditor.setAmount(creditor.getAmount() + subject.getAmount());

            try {
                Statement statement = connection.createStatement();
                String sql = "UPDATE parties SET amount=" + debtor.getAmount() + " WHERE party_name = '" + debtor.getName() + "'";
                statement.executeUpdate(sql);
                sql = "UPDATE parties SET amount = " + creditor.getAmount() + " WHERE party_name = '" + creditor.getName() + "'";
                statement.executeUpdate(sql);
                model.updateParties();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
