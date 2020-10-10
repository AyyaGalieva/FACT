package GUI;

import Entities.Party;
import Model.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    private MainPanel mainPanel;
    private RightPanel rightPanel;
    private MenuBar menuBar;
    private JToolBar toolBar;
    private JLabel statusBar;
    private JScrollPane scrollPane;

    private Map<String, AbstractButton> buttonMap = new TreeMap<>();
    private Map<String, Menu> menuMap = new TreeMap<>();
    private Map<String, MenuItem> menuItemMap = new TreeMap<>();

    private Model model;

    public GUI(Model model) {
        this.model = model;
        mainPanel = new MainPanel();
        rightPanel = new RightPanel();
        setTitle("FACT");
        setSize(1000, 800);
        setResizable(false);
        setMinimumSize(new Dimension(600, 400));

        setLocationByPlatform(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new MenuBar();
        toolBar = new JToolBar();
        this.setMenuBar(menuBar);

        statusBar = new JLabel();
        statusBar.setPreferredSize(new Dimension(150, 15));
        statusBar.setBackground(Color.white);

        scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.WEST);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(rightPanel);

        addButton("Перевести", "Контракт", "Перевести текст контракта", true, "/translate.png", () -> {
            mainPanel.clearEditPanel();
            model.generateText(mainPanel.getContractText());
            mainPanel.enableTextArea(true);
            mainPanel.repaintEditField();
        });

        addButton("Запуск", "Контракт", "Запустить контракт", true, "/run.png", () -> {
            model.runContract(mainPanel.getContractText());
            mainPanel.enableTextArea(false);

            buttonMap.get("Запуск").setEnabled(false);
            menuItemMap.get("Запуск").setEnabled(false);
            buttonMap.get("Стоп").setEnabled(true);
            menuItemMap.get("Стоп").setEnabled(true);
        });

        addButton("Стоп", "Контракт", "Завершить исполнение контракта", true, "/pause.png", () -> {
            model.stopContract();
            buttonMap.get("Стоп").setEnabled(false);
            menuItemMap.get("Стоп").setEnabled(false);
            buttonMap.get("Запуск").setEnabled(true);
            menuItemMap.get("Запуск").setEnabled(true);
        });

        buttonMap.get("Стоп").setEnabled(false);
        menuItemMap.get("Стоп").setEnabled(false);

        toolBar.addSeparator();

        addButton("Сохранить", "Файл", "Сохранить контракт", true, "/save.png", () -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/contracts/");
            fileChooser.setDialogTitle("Save state");
            int f = fileChooser.showSaveDialog(GUI.this);
            if (f == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                model.saveContract(file.getAbsolutePath(), mainPanel.getContractStr());
            }
        });

        addButton("Загрузить", "Файл", "Загрузить контракт", true, "/load.png", () -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/contracts/");
            fileChooser.setDialogTitle("Загрузить контракт");
            int f = fileChooser.showOpenDialog(GUI.this);
            if (f == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                model.loadContract(file.getAbsolutePath());
            }
        });

        add(toolBar, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);
    }

    private void addButton(String name, String menuName, String toolTipText, boolean shutdown, String imagePath, Runnable action) {
        AbstractButton button;
        MenuItem item;

        Image toolImage = null;
        try {
            toolImage = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        if (shutdown) {
            if (toolImage != null) {
                button = new JButton();
                button.setIcon(new ImageIcon(toolImage));
            }
            else {
                button = new JButton(name);
            }
            item = new MenuItem(name);
            item.addActionListener(e -> {
                if (item.isEnabled()) {
                    action.run();
                }
            });
        }
        else {
            if (toolImage != null) {
                button = new JToggleButton();
                button.setIcon(new ImageIcon(toolImage));
            }
            else {
                button = new JToggleButton(name);
            }
            CheckboxMenuItem checkboxMenuItem = new CheckboxMenuItem(name);
            checkboxMenuItem.addItemListener(e -> {
                if (checkboxMenuItem.isEnabled())
                    action.run();
            });
            item = checkboxMenuItem;
        }

        button.setToolTipText(toolTipText);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            boolean pressedOrEntered = false;
            @Override
            public void mouseReleased(MouseEvent e) {
                if (button.isEnabled() && pressedOrEntered)
                    action.run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pressedOrEntered = true;
                statusBar.setText(toolTipText);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusBar.setText("");
                pressedOrEntered = false;
            }
        };

        button.addMouseListener(mouseAdapter);
        toolBar.add(button);

        if (!menuMap.containsKey(menuName)) {
            Menu menu = new Menu(menuName);
            menuMap.put(menuName, menu);
            menuBar.add(menu);
        }
        menuMap.get(menuName).add(item);
        menuItemMap.put(name, item);
        buttonMap.put(name, button);
    }

    public void updateTime(long seconds) {
        rightPanel.updateTime(seconds);
    }

    public void setParties(ArrayList<Party> parties) {
        rightPanel.setParties(parties);
    }

    public void showContractIncorrect(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "error", JOptionPane.WARNING_MESSAGE);
    }

    public void addEvent(String name, HashMap<String, Boolean> properties, Runnable action) {
        rightPanel.addEvent(name, properties, action);
    }

    public void clearData() {
        mainPanel.enableTextArea(true);
        rightPanel.clear();
    }

    public void addText(String str) {
        mainPanel.addLabel(str);
    }

    public void addEditField(String str) {
        mainPanel.addTextField(str);
    }

    public void setTextContract(String contractStr) { mainPanel.setTextContract(contractStr); }
}
