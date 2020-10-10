package Model;

import Entities.*;
import gen.FACTBaseListener;
import gen.FACTParser;
import org.antlr.v4.runtime.tree.ErrorNode;

public class TextGenerator extends FACTBaseListener {
    private Model model;
    private String errorMessage = "";

    public void visitErrorNode(ErrorNode node) {
        errorMessage = "Error occurred: "+ node.getText();
    }

    public void enterHas(FACTParser.HasContext ctx) {
        String name = ctx.getChild(0).getChild(1).getText();
        try {
            Integer amount = Integer.parseInt(ctx.getChild(2).getChild(1).getText());
            model.addText("Сторона " + name + " обладает активом в " + amount.toString() + " единиц. ");
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

        String subjectType = ctx.getChild(4).getChild(0).getText().trim();
        if (subjectType.equals(Subject.AMOUNT.toString())) {
            subject = Subject.AMOUNT;
            int amount = Integer.parseInt(ctx.getChild(4).getChild(1).getText());
            subject.setAmount(amount);
        } else if (subjectType.equals(Subject.SERVICE.toString())) {
            subject = Subject.SERVICE;
            String service = ctx.getChild(4).getChild(1).getText();
            model.addText("Сторона " + debtorName + " обязуется оказать сервис " + service + " стороне " + creditorName + ". ");
            return;
        }

        int term = -1;
        String eventName = "";
        String conditionsType = ctx.getChild(6).getChild(1).getChild(0).getText().trim();

        if (conditionsType.equals("TERM")) {
            term = Integer.parseInt(ctx.getChild(6).getChild(1).getChild(1).getText());
        } else {
            eventName = ctx.getChild(6).getChild(1).getChild(1).getText();
            model.addText("Сторона " + debtorName + " обязуется выплатить " + subject.getAmount() + " единиц стороне " + creditorName + ", при свершении " + eventName + ". ");
        }

        if (term > 0) {
            model.addText("Сторона " + debtorName + " обязуется выплатить " + subject.getAmount() + " единиц, по истечении срока " + term + ". ");
        }
    }

    public void enterIncludes(FACTParser.IncludesContext ctx) {
        String serviceName = ctx.getChild(0).getChild(1).getText();

        String serviceConstituentType = ctx.getChild(2).getChild(0).getText().trim();
        if (serviceConstituentType.equals(ServiceConstituent.TERM.toString())) {
            int term = Integer.parseInt(ctx.getChild(2).getChild(1).getText());
            model.addText("Сервис "+ serviceName + " обязан быть предоставлен в срок, ограниченный " + term + ". ");
        } else if (serviceConstituentType.equals(ServiceConstituent.PROPERTY.toString())) {
            String property = ctx.getChild(2).getChild(1).getText();
            model.addText("Сервис " + serviceName + " включает в себя соблюдения требования " + property + ". ");
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
