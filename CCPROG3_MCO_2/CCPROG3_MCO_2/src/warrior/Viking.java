package warrior;

/**
 * Represents a Viking opponent.
 * The Viking alternates between attacking and defending.
 */
public class Viking extends Opponent {

    private boolean defending;

    public Viking() {
        super("Viking");
        defending = false;
    }

    @Override
    public String Think() {

        if (!defending) {
            defending = true;
            return "Attack";
        }
        else {
            defending = false;
            return "Defend";
        }
    }
}
