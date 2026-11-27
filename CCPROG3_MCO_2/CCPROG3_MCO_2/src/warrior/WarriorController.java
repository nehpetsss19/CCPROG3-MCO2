
package warrior;

import javax.swing.JOptionPane;

public class WarriorController {

    private WarriorView view;
    private Warrior warrior;
    private Opponent opponent;
    private Environment environment;
    private Battle battle;

    private int turn;
    private boolean battleStarted;

    public WarriorController(WarriorView view) {

        this.view = view;

        turn = 1;
        battleStarted = false;

        view.getAttackButton().setEnabled(false);
        view.getDefendButton().setEnabled(false);
        view.getChargeButton().setEnabled(false);

        view.getStartButton().addActionListener(e -> startBattle());
        view.getAttackButton().addActionListener(e -> attack());
        view.getDefendButton().addActionListener(e -> defend());
        view.getChargeButton().addActionListener(e -> charge());
    }

    private void startBattle() {

        String name = view.getWarriorName().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                view, "Please enter your warrior's name."
            );
            return;
        }

        warrior = new Warrior(name);

        // Select armor.
        String armorChoice = view.getArmorChoice();
        Armor armor;

        if (armorChoice.equals("Light")) {
            armor = new LightArmor();
        }
        else if (armorChoice.equals("Medium")) {
            armor = new MediumArmor();
        }
        else if (armorChoice.equals("Heavy")) {
            armor = new HeavyArmor();
        }
        else {
            armor = new BladeArmor();
        }

        warrior.equipArmor(armor);

        // Select weapon.
        String weaponChoice = view.getWeaponChoice();
        Weapon weapon;

        if (weaponChoice.equals("Dagger")) {
            weapon = new Dagger();
        }
        else if (weaponChoice.equals("Sword")) {
            weapon = new Sword();
        }
        else if (weaponChoice.equals("Battle Axe")) {
            weapon = new BattleAxe();
        }
        else if (weaponChoice.equals("Spear")) {
            weapon = new Spear();
        }
        else {
            weapon = new Bow();
        }

        warrior.equipWeapon(weapon);

        // Select opponent.
        String opponentChoice = view.getOpponentChoice();

        if (opponentChoice.equals("Thief")) {
            opponent = new Thief();
        }
        else if (opponentChoice.equals("Viking")) {
            opponent = new Viking();
        }
        else if (opponentChoice.equals("Minotaur")) {
            opponent = new Minotaur();
        }
        else {
            opponent = new Cyclops();
        }

        // Select environment.
        environment = new Environment(view.getEnvironmentChoice());

        // Create battle and connect messages to GUI.
        battle = new Battle(warrior, opponent, environment);
        battle.setMessageListener(view::addLog);

        battleStarted = true;
        turn = 1;

        view.clearLog();

        view.addLog("THE BATTLE BEGINS!");
        view.addLog("");
        view.addLog(warrior.getName() + " VS " + opponent.getName());
        view.addLog("Battle location: " + environment.getName());
        view.addLog("");

        view.getStartButton().setEnabled(false);
        view.getAttackButton().setEnabled(true);
        view.getDefendButton().setEnabled(true);
        view.getChargeButton().setEnabled(true);

        startTurn();
    }

    private void startTurn() {

        if (!battleStarted) {
            return;
        }

        view.addLog("TURN " + turn);

        battle.startBattle();

        updateHP();

        if (!checkWinner()) {
            view.addLog("Choose your move!");
            view.addLog("");
        }
    }

    private void attack() {

        if (!battleStarted) {
            return;
        }

        view.addLog(warrior.getName() + " attacks!");

        battle.attack();

        finishTurn();
    }

    private void defend() {

        if (!battleStarted) {
            return;
        }

        view.addLog(warrior.getName() + " takes a defensive stance!");

        battle.defend();

        finishTurn();
    }

    private void charge() {

        if (!battleStarted) {
            return;
        }

        view.addLog(warrior.getName() + " chooses to charge!");

        battle.charge();

        finishTurn();
    }

    private void finishTurn() {

        updateHP();

        if (checkWinner()) {
            return;
        }

        turn++;

        view.addLog("");
        startTurn();
    }

    private void updateHP() {

        view.updateHP(warrior.getHP(), opponent.getHP());

        view.addLog("CURRENT HP");
        view.addLog(warrior.getName() + ": " + warrior.getHP());
        view.addLog(opponent.getName() + ": " + opponent.getHP());
        view.addLog("");
    }

    private boolean checkWinner() {

        if (!warrior.isAlive() && !opponent.isAlive()) {
            view.addLog("It's a tie!");
        }
        else if (!warrior.isAlive()) {
            view.addLog("The opponent wins!");
        }
        else if (!opponent.isAlive()) {
            view.addLog("The warrior wins!");
        }
        else {
            return false;
        }

        view.addLog("THAT'S THE END OF THE BATTLE!");

        battleStarted = false;

        view.getAttackButton().setEnabled(false);
        view.getDefendButton().setEnabled(false);
        view.getChargeButton().setEnabled(false);

        return true;
    }
}
