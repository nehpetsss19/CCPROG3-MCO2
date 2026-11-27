package warrior;

import javax.swing.*;
import java.awt.*;

public class WarriorView extends JFrame {

    private JTextField nameField;

    private JComboBox<String> armorBox;
    private JComboBox<String> weaponBox;
    private JComboBox<String> opponentBox;
    private JComboBox<String> environmentBox;

    private JButton startButton;
    private JButton attackButton;
    private JButton defendButton;
    private JButton chargeButton;

    private JLabel warriorHPLabel;
    private JLabel opponentHPLabel;

    private JTextArea battleLog;

    public WarriorView() {
        setTitle("WARRIOR BATTLE");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        createSetupPanel();
        createBattlePanel();

        setVisible(true);
    }

    private void createSetupPanel() {

        JPanel setupPanel = new JPanel(new GridLayout(6, 2, 8, 8));
        setupPanel.setBorder(
            BorderFactory.createTitledBorder("WARRIOR SETUP"));

        nameField = new JTextField();

        armorBox = new JComboBox<>(new String[]{
            "Light", "Medium", "Heavy", "Blade"
        });

        weaponBox = new JComboBox<>(new String[]{
            "Dagger", "Sword", "Battle Axe", "Spear", "Bow"
        });

        opponentBox = new JComboBox<>(new String[]{
            "Thief", "Viking", "Minotaur", "Cyclops"
        });

        environmentBox = new JComboBox<>(new String[]{
            "Arena", "Swamp", "Colosseum", "Lotus Eaters"
        });

        startButton = new JButton("START BATTLE");

        setupPanel.add(new JLabel("Warrior Name:"));
        setupPanel.add(nameField);

        setupPanel.add(new JLabel("Choose Armor:"));
        setupPanel.add(armorBox);

        setupPanel.add(new JLabel("Choose Weapon:"));
        setupPanel.add(weaponBox);

        setupPanel.add(new JLabel("Choose Opponent:"));
        setupPanel.add(opponentBox);

        setupPanel.add(new JLabel("Choose Environment:"));
        setupPanel.add(environmentBox);

        setupPanel.add(new JLabel(""));
        setupPanel.add(startButton);

        add(setupPanel, BorderLayout.NORTH);
    }

    private void createBattlePanel() {

        JPanel battlePanel = new JPanel(new BorderLayout(8, 8));
        battlePanel.setBorder(
            BorderFactory.createTitledBorder("BATTLE"));

        JPanel hpPanel = new JPanel(new GridLayout(1, 2));

        warriorHPLabel = new JLabel("Warrior HP: 100");
        opponentHPLabel = new JLabel("Opponent HP: 100");

        hpPanel.add(warriorHPLabel);
        hpPanel.add(opponentHPLabel);

        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setLineWrap(true);
        battleLog.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(battleLog);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 8, 8));

        attackButton = new JButton("ATTACK");
        defendButton = new JButton("DEFEND");
        chargeButton = new JButton("CHARGE");

        buttonPanel.add(attackButton);
        buttonPanel.add(defendButton);
        buttonPanel.add(chargeButton);

        battlePanel.add(hpPanel, BorderLayout.NORTH);
        battlePanel.add(scrollPane, BorderLayout.CENTER);
        battlePanel.add(buttonPanel, BorderLayout.SOUTH);

        add(battlePanel, BorderLayout.CENTER);
    }

    public String getWarriorName() {
        return nameField.getText();
    }

    public String getArmorChoice() {
        return (String) armorBox.getSelectedItem();
    }

    public String getWeaponChoice() {
        return (String) weaponBox.getSelectedItem();
    }

    public String getOpponentChoice() {
        return (String) opponentBox.getSelectedItem();
    }

    public String getEnvironmentChoice() {
        return (String) environmentBox.getSelectedItem();
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getAttackButton() {
        return attackButton;
    }

    public JButton getDefendButton() {
        return defendButton;
    }

    public JButton getChargeButton() {
        return chargeButton;
    }

    public void updateHP(int warriorHP, int opponentHP) {
        warriorHPLabel.setText("Warrior HP: " + warriorHP);
        opponentHPLabel.setText("Opponent HP: " + opponentHP);
    }

    public void addLog(String message) {
        battleLog.append(message + "\n");
    }

    public void clearLog() {
        battleLog.setText("");
    }
}
