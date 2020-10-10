package Model;

import Entities.*;
import gen.FACTBaseListener;
import gen.FACTParser;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.ArrayList;
import java.util.List;

public class FACTWalker extends FACTBaseListener {
    private Model model;
    private ArrayList<Party> parties = new ArrayList<>();
    private String errorMessage = "";
    private List<ObligationTimerTask> obligationTimerTasks = new ArrayList<>();
    private List<ObligationServiceTask> obligationServiceTasks = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();

    public void visitErrorNode(ErrorNode node) {
        errorMessage = "Error occurred: "+ node.getText();
    }

    public void enterHas(FACTParser.HasContext ctx) {
        String name = ctx.getChild(0).getChild(1).getText();
        try {
            Integer amount = Integer.parseInt(ctx.getChild(2).getChild(1).getText());
            parties.add(new Party(name, amount));
        } catch (Exception e) {
            errorMessage = "AMOUNT must be integer";
        }
    }

    public void enterOwes(FACTParser.OwesContext ctx) {
        Party debtor = null;
        Party creditor = null;
        Subject subject = null;

        String debtorName = ctx.getChild(0).getChild(1).getText();
        String creditorName = ctx.getChild(2).getChild(1).getText();

        for (Party party : parties) {
            if (party.getName().equals(debtorName)) {
                debtor = party;
            }
            if (party.getName().equals(creditorName)) {
                creditor = party;
            }
        }

        String subjectType = ctx.getChild(4).getChild(0).getText().trim();
        if (subjectType.equals(Subject.AMOUNT.toString())) {
            subject = Subject.AMOUNT;
            int amount = Integer.parseInt(ctx.getChild(4).getChild(1).getText());
            subject.setAmount(amount);
            subjects.add(subject);
        } else if (subjectType.equals(Subject.SERVICE.toString())) {
            subject = Subject.SERVICE;
            String service = ctx.getChild(4).getChild(1).getText();
            subject.setService(service);
            subjects.add(subject);
            createObligationEventTask(debtor, creditor, subject.getService());
            return;
        }

        int term = -1;
        String eventName = "";
        String conditionsType = ctx.getChild(6).getChild(1).getChild(0).getText().trim();

        if (conditionsType.equals("TERM")) {
            term = Integer.parseInt(ctx.getChild(6).getChild(1).getChild(1).getText());
        } else {
            eventName = ctx.getChild(6).getChild(1).getChild(1).getText();

            Boolean eventNameIsValid = false;
            for (Subject s : subjects) {
                if (s.getServiceName().equals(eventName)) {
                    for (ObligationServiceTask obligation : obligationServiceTasks) {
                        if (obligation.getService().getServiceName().equals(eventName)) {
                            obligation.setSubject(subject);
                            obligation.setDebtor(debtor);
                            obligation.setCreditor(creditor);
                            model.addEvent(obligation.getService());
                            break;
                        }
                    }
                    eventNameIsValid = true;
                }
            }
            if (!eventNameIsValid) {
                errorMessage = "unresolved event " + eventName;
            }
        }

        if (debtor == null || creditor == null || subject == null) {
            System.err.println("Party has not been init.");
        } else if (term > 0) {
            obligationTimerTasks.add(new ObligationTimerTask(model, debtor, creditor, subject, term));
        }
    }

    public void enterIncludes(FACTParser.IncludesContext ctx) {
        String serviceName = ctx.getChild(0).getChild(1).getText();
        Service service = null;
        for (ObligationServiceTask obligation : obligationServiceTasks) {
            if (obligation.getService().getServiceName().equals(serviceName)) {
                service = obligation.getService();
            }
        }
        if (service == null) {
            errorMessage = "Unknown service name";
            return;
        }

        String serviceConstituentType = ctx.getChild(2).getChild(0).getText().trim();
        if (serviceConstituentType.equals(ServiceConstituent.TERM.toString())) {
            int term = Integer.parseInt(ctx.getChild(2).getChild(1).getText());
            service.setTerm(term);
        } else if (serviceConstituentType.equals(ServiceConstituent.PROPERTY.toString())) {
            String property = ctx.getChild(2).getChild(1).getText();
            service.addProperty(property);
        }
    }

    private void createObligationEventTask(Party debtor, Party creditor, Service service) {
        obligationServiceTasks.add(new ObligationServiceTask(model, debtor, creditor, service));
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public List<ObligationTimerTask> getObligationTimerTasks() {
        return obligationTimerTasks;
    }

    public List<ObligationServiceTask> getObligationServiceTasks() {
        return obligationServiceTasks;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
