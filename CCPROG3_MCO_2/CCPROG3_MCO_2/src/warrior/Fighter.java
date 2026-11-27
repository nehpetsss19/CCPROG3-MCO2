package warrior;

public class Fighter {

    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int speed;

    public Fighter(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;

        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void increaseAttack(int amount) {
        attack = attack + amount;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}


