
package warrior;

/**
 * This class contains the opponents that the warrior can fight.
 * Each opponent has different HP, attack, defense, and speed.
 */
public class Opponent extends Fighter {

    /**
     * Creates an opponent and initializes its stats
     * based on the selected opponent name.
     *
     * @param name the name of the opponent
     */
    public Opponent(String name) {
        super(name);

        if (name.equals("Thief")) {
            hp = 150;
            attack = 20;
            defense = 20;
            speed = 40;
        }
        else if (name.equals("Viking")) {
            hp = 250;
            attack = 30;
            defense = 30;
            speed = 30;
        }
        else if (name.equals("Minotaur")) {
            hp = 350;
            attack = 40;
            defense = 40;
            speed = 20;
        }

        /*
         * Cyclops is an additional opponent inspired by the
         * scary Cyclops scene from The Odyssey.
         * It has high HP and attack, but moves very slowly.
         */
        else if (name.equals("Cyclops")) {
            hp = 290;
            attack = 40;
            defense = 30;
            speed = 10;
        }
    }
    

    /**
     * Reduces the opponent's defense points by the given amount.
     *
     * @param amount the amount of defense to reduce
     */
    public void decreaseDefense(int amount) {
        defense = defense - amount;
    }

	/**
	 * Determines the opponent's next action.
	 * Child classes override this method with their own AI behavior.
	 *
	 * @return the opponent's selected action
	 */
	public String Think() {
	    return "Attack";
	}
}
