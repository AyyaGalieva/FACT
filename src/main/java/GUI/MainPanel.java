package GUI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel textPanel = new JPanel();
    private JTextArea textArea;
    private JPanel editPanel = new JPanel();

    public MainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textArea = new JTextArea(20, 60);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textPanel.add(textArea);
        this.add(textPanel);
        editPanel.setPreferredSize(new Dimension(200, 200));
        this.add(editPanel);
    }

    public void addLabel(String str) {
        editPanel.add(new JLabel(str));
    }

    public void addTextField(String str) {
        editPanel.add(new JTextField(str));
    }

    public String getContractText() {
        return textArea.getText();
    }

    public void enableTextArea(Boolean isEnabled) {
        textArea.setEditable(isEnabled);
    }
}
