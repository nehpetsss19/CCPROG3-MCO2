package warrior;

/**
 * Represents a Minotaur opponent.
 * The Minotaur alternates between attacking and charging.
 */
public class Minotaur extends Opponent {

    private boolean charging;

    public Minotaur() {
        super("Minotaur");
        charging = false;
    }

    @Override
    public String Think() {

        if (!charging) {
            charging = true;
            return "Attack";
        }
        else {
            charging = false;
            return "Charge";
        }
    }
}
