package GUI;

import Entities.Party;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RightPanel extends JPanel {
    private JLabel timeLabel;
    private ArrayList<JLabel> partiesLabels;
    private Set<String> eventNames = new HashSet<>();
    private JPanel partiesPanel = new JPanel();
    private JPanel eventsPanel = new JPanel();

    public RightPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("StudioScriptCTT", Font.BOLD, 20));
        resetTimer();
        this.add(timeLabel);
        partiesPanel.setLayout(new BoxLayout(partiesPanel, BoxLayout.Y_AXIS));
        this.add(partiesPanel);
        eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
        this.add(eventsPanel);
        partiesLabels = new ArrayList<>();
    }

    private void resetTimer() {
        timeLabel.setText("0:00");
        timeLabel.setForeground(new Color(165, 161, 160));
    }

    public void updateTime(long seconds) {
        timeLabel.setForeground(new Color(0, 0, 0));
        long minutes = seconds / 60;
        String str = String.format("%d:%02d", minutes, seconds % 60);
        timeLabel.setText(str);
    }

    public void setParties(ArrayList<Party> parties) {
        for (Party p : parties) {
            Boolean exists = false;
            for (JLabel pl : partiesLabels) {
                String name = pl.getText().split(":")[0];
                if (p.getName().equals(name)) {
                    pl.setText(p.getName() + ": " + p.getAmount());
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                JLabel partyLabel = new JLabel();
                partyLabel.setText(p.getName() + ": " + p.getAmount());
                partiesPanel.add(partyLabel);
                partiesLabels.add(partyLabel);
            }
        }
    }

    public void addEvent(String eventName, HashMap<String, Boolean> properties, Runnable action) {
        if (!eventNames.contains(eventName)) {
            JButton button = new JButton();
            button.setText(eventName);
            for (Map.Entry<String, Boolean> property : properties.entrySet()) {
                JCheckBox prop = new JCheckBox(property.getKey());
                prop.addItemListener(e -> {
                    properties.put(property.getKey(), prop.isSelected());
                });
                eventsPanel.add(prop);
            }
            eventsPanel.add(button);
            eventNames.add(eventName);
            button.addActionListener(e -> {
                action.run();
            });
        }
    }

    public void clear() {
        resetTimer();
    }
}
