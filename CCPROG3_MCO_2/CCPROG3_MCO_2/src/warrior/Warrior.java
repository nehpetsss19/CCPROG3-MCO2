
package warrior;

/**
 * This class handles the warrior's equipment.
 * It inherits the common stats and methods from Fighter.
 * The warrior starts with basic stats and can equip armor and a weapon.
 */
public class Warrior extends Fighter {

    private Armor armor;
    private Weapon weapon;
    private int defendCount;

    /**
     * Creates a warrior with the given name and initializes
     * the warrior's starting stats.
     *
     * @param name the name of the warrior
     */
    public Warrior(String name) {
        super(name);

        hp = 100;
        attack = 1;
        defense = 1;
        speed = 50;
        defendCount = 0;
    }

    /**
     * Equips the selected armor and updates the warrior's
     * defense and speed.
     *
     * @param armor the armor equipped by the warrior
     */
    public void equipArmor(Armor armor) {
        this.armor = armor;
        defense = 1 + armor.getExtraDefense();
        speed = 50 - armor.getSpeedReduction();
    }

    /**
     * Equips the selected weapon and updates the warrior's
     * attack and speed.
     *
     * @param weapon the weapon equipped by the warrior
     */
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        attack = 1 + weapon.getExtraAttack();
        speed = speed - weapon.getSpeedReduction();
    }

    /**
     * Checks whether the warrior is equipped with Blade Armor.
     *
     * @return true if the warrior has Blade Armor equipped
     */
    public boolean hasBladeArmor() {
        return armor != null && armor.getType().equals("Blade");
    }

    /**
     * Checks whether the warrior is using a Dagger.
     *
     * @return true if the warrior has a Dagger equipped
     */
    public boolean hasDagger() {
        return weapon instanceof Dagger;
    }

    /**
     * Checks whether the warrior is using a Sword.
     *
     * @return true if the warrior has a Sword equipped
     */
    public boolean hasSword() {
        return weapon instanceof Sword;
    }

    /**
     * Checks whether the warrior is using a Battle Axe.
     *
     * @return true if the warrior has a Battle Axe equipped
     */
    public boolean hasBattleAxe() {
        return weapon instanceof BattleAxe;
    }

    /**
     * Checks whether the warrior evades an attack.
     * Every second defend with a Dagger becomes a 100% evade.
     *
     * @return true if the warrior successfully evades
     */
    public boolean shouldEvade() {
        if (hasDagger()) {
            defendCount++;

            if (defendCount % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the warrior's attack including the Sword ability.
     *
     * @return attack points with the additional Sword bonus
     */
    public int getAttackWithWeaponAbility() {
        if (hasSword()) {
            return attack + 10;
        }

        return attack;
    }

    /**
     * Returns the warrior's attack including the Battle Axe
     * bonus when attacking on the turn after charging.
     *
     * @param charged indicates whether the warrior has a charged attack
     * @return attack points including applicable weapon bonuses
     */
    public int getAttackWithChargeBonus(boolean charged) {
        int totalAttack = getAttackWithWeaponAbility();

        if (hasBattleAxe() && charged) {
            totalAttack = totalAttack + 5;
        }

        return totalAttack;
    }

    /**
     * Returns the warrior's speed including the Battle Axe
     * bonus when attacking on the turn after charging.
     *
     * @param charged indicates whether the warrior has a charged attack
     * @return speed including applicable weapon bonuses
     */
    public int getSpeedWithChargeBonus(boolean charged) {
        if (hasBattleAxe() && charged) {
            return speed + 5;
        }

        return speed;
    }
}
