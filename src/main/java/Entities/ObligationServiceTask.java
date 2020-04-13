package Entities;

import Model.Model;

import java.sql.Connection;
import java.sql.Statement;

public class ObligationServiceTask {
    private Model model;

    private Party debtor;
    private Party creditor;

    private Subject subject;

    private Service service;

    private Connection connection;

    public ObligationServiceTask(Model model, Party debtor, Party creditor, Service service) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.model = model;
        this.service = service;
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

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void run() {
        if (connection == null) { return; }
        if (subject == Subject.AMOUNT) {
            debtor.setAmount(debtor.getAmount() - subject.getAmount());
            creditor.setAmount(creditor.getAmount() + subject.getAmount());
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE parties SET amount=" + debtor.getAmount() + " WHERE party_name = '" + debtor.getName() + "'");
                statement.executeUpdate("UPDATE parties SET amount = " + creditor.getAmount() + " WHERE party_name = '" + creditor.getName() + "'");
                model.updateParties();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
