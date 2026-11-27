package warrior;

/**
 * This class handles the places where the battles happen.
 * Each place has a different effect during the fight.
 */
public class Environment {

    private String name;

    /**
     * Creates an environment object using the selected environment name.
     *
     * @param name the name of the selected environment
     */
    public Environment(String name) {
        this.name = name;
    }

    /**
     * Applies the effects of the selected environment to the warrior
     * and the opponent during battle.
     *
     * @param warrior the warrior participating in the battle
     * @param opponent the opponent participating in the battle
     */
    public void applyEffects(Warrior warrior, Opponent opponent) {

        if (name.equals("Colosseum")) {
            warrior.increaseAttack(1);
            opponent.decreaseDefense(1);
        }
        else if (name.equals("Swamp")) {
            warrior.takeDamage(1);
            opponent.increaseAttack(1);
        }
        /*
         * Lotus Eaters is inspired by The Odyssey.
         * The lotus slowly weakens the warrior, while the
         * opponent also loses some defense.
         */
        else if (name.equals("Lotus Eaters")) {
            warrior.takeDamage(1);
            opponent.decreaseDefense(1);
        }
    }

    /**
     * Returns the name of the selected environment.
     *
     * @return the selected environment name
     */
    public String getName() {
        return name;
    }
}
