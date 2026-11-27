
package warrior;

/**
 * Parent class for all armor types.
 * Each armor provides additional defense and reduces speed.
 */
public class Armor {

    private String type;
    private int extraDefense;
    private int speedReduction;

    /**
     * Creates an armor with its specified stats.
     *
     * @param type the armor type
     * @param extraDefense the additional defense
     * @param speedReduction the speed reduction
     */
    public Armor(String type, int extraDefense, int speedReduction) {
        this.type = type;
        this.extraDefense = extraDefense;
        this.speedReduction = speedReduction;
    }

    /**
     * Returns the armor type.
     *
     * @return the armor type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the additional defense.
     *
     * @return the additional defense
     */
    public int getExtraDefense() {
        return extraDefense;
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
