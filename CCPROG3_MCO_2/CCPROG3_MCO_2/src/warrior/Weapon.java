
package warrior;

/**
 * Parent class for all weapon types.
 * Each weapon provides additional attack and speed reduction.
 */
public class Weapon {

    private String type;
    private int extraAttack;
    private int speedReduction;

    /**
     * Creates a weapon with its specified stats.
     *
     * @param type the weapon type
     * @param extraAttack the additional attack points
     * @param speedReduction the speed reduction
     */
    public Weapon(String type, int extraAttack, int speedReduction) {
        this.type = type;
        this.extraAttack = extraAttack;
        this.speedReduction = speedReduction;
    }

    /**
     * Returns the weapon type.
     *
     * @return the weapon type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the additional attack points.
     *
     * @return the additional attack points
     */
    public int getExtraAttack() {
        return extraAttack;
    }

    /**
     * Returns the speed reduction.
     *
     * @return the speed reduction
     */
    public int getSpeedReduction() {
        return speedReduction;
    }
}
