package warrior;

/**
 * Represents a Thief opponent.
 * The Thief continuously attacks.
 */
public class Thief extends Opponent {

    public Thief() {
        super("Thief");
    }

    @Override
    public String Think() {
        return "Attack";
    }
}
