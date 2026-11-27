
package warrior;

import java.util.function.Consumer;

public class Battle {

    private Warrior warrior;
    private Opponent opponent;
    private Environment environment;
    private int turn;
    private boolean charged;
    private boolean canCharge;
    private boolean opponentCharged;
    private Consumer<String> messageListener;

    public Battle(Warrior warrior, Opponent opponent,
                  Environment environment) {

        this.warrior = warrior;
        this.opponent = opponent;
        this.environment = environment;

        turn = 0;
        charged = false;
        canCharge = true;
        opponentCharged = false;
        messageListener = null;
    }

    // Connects battle messages to the GUI.
    public void setMessageListener(Consumer<String> listener) {
        messageListener = listener;
    }

    // Displays messages in the GUI or console.
    private void log(String message) {
        if (messageListener != null) {
            messageListener.accept(message);
        }
        else {
            System.out.println(message);
        }
    }

    // Calculates damage after defense.
    public int calculateDamage(int attack, int defense) {

        int damage = attack - defense;

        if (damage < 0) {
            damage = 0;
        }

        return damage;
    }

    // Starts a new battle turn and applies environment effects.
    public void startBattle() {

        turn = turn + 1;
        environment.applyEffects(warrior, opponent);
    }

    // Handles the warrior's attack.
    public void attack() {

        boolean chargeBonus = charged;
        String action = opponent.Think();

        if (action.equals("Defend")) {

            log("The Viking is defending!");
            warriorAttack(true, chargeBonus);

        }
        else if (action.equals("Charge")) {

            log("The Minotaur is charging!");
            opponentCharged = true;
            warriorAttack(false, chargeBonus);

        }
        else {

            log("Warrior Speed: "
                    + warrior.getSpeedWithChargeBonus(chargeBonus));

            log("Opponent Speed: " + opponent.getSpeed());

            if (warrior.getSpeedWithChargeBonus(chargeBonus)
                    >= opponent.getSpeed()) {

                warriorAttack(false, chargeBonus);

                if (opponent.isAlive()) {
                    opponentAttack(false, opponentCharged);
                }

            }
            else {

                opponentAttack(false, opponentCharged);

                if (warrior.isAlive() && opponent.isAlive()) {
                    warriorAttack(false, chargeBonus);
                }

            }
        }

        if (action.equals("Attack")) {
            opponentCharged = false;
        }

        if (chargeBonus) {
            charged = false;
        }

        canCharge = true;
    }

    // Calculates and applies the warrior's attack damage.
    private void warriorAttack(boolean opponentDefending,
                               boolean chargeBonus) {

        int warriorAttack;
        int damage;

        warriorAttack = warrior.getAttackWithChargeBonus(chargeBonus);

        damage = calculateDamage(
            warriorAttack, opponent.getDefense()
        );

        if (opponentDefending) {
            damage = damage / 2;
        }

        if (chargeBonus) {
            damage = damage * 3;
        }

        opponent.takeDamage(damage);
    }

    // Calculates and applies the opponent's attack damage.
    private void opponentAttack(boolean defending,
                                boolean chargeBonus) {

        int damage;

        log("The " + opponent.getName() + " attacks!");

        damage = calculateDamage(
            opponent.getAttack(), warrior.getDefense()
        );

        if (defending) {
            damage = damage / 2;
        }

        if (chargeBonus) {
            damage = damage * 3;
        }

        warrior.takeDamage(damage);

        log("Damage dealt to " + warrior.getName() + ": " + damage);

        // Blade Armor damages the opponent when attacked.
        if (warrior.hasBladeArmor()) {
            opponent.takeDamage(5);
            log("Blade Armor dealt 5 damage to the opponent!");
        }
    }

    // Handles the warrior's defensive action.
    public void defend() {

        boolean evade = warrior.shouldEvade();
        String action = opponent.Think();

        if (action.equals("Attack")) {

            if (evade) {
                log("Dagger ability activated! You evaded the attack!");
            }
            else {
                opponentAttack(true, opponentCharged);
            }

            opponentCharged = false;

        }
        else if (action.equals("Defend")) {

            log("The Viking is defending!");

        }
        else if (action.equals("Charge")) {

            log("The Minotaur is charging!");
            opponentCharged = true;

        }

        charged = false;
        canCharge = true;
    }

    // Handles the warrior's charging action.
    public void charge() {

        if (canCharge && !charged) {
            charged = true;
            canCharge = false;
        }
        else {
            log("You cannot charge again yet!");
        }

        String action = opponent.Think();

        if (action.equals("Attack")) {

            opponentAttack(false, opponentCharged);
            opponentCharged = false;

        }
        else if (action.equals("Defend")) {

            log("The Viking is defending!");

        }
        else if (action.equals("Charge")) {

            log("The Minotaur is charging!");
            opponentCharged = true;

        }
    }

    // Checks whether either fighter has been defeated.
    public boolean checkWinner() {

        if (!warrior.isAlive() && !opponent.isAlive()) {

            log("It's a tie!");
            return true;

        }
        else if (!warrior.isAlive()) {

            log("The opponent wins!");
            return true;

        }
        else if (!opponent.isAlive()) {

            log("The warrior wins!");
            return true;

        }

        return false;
    }

}
