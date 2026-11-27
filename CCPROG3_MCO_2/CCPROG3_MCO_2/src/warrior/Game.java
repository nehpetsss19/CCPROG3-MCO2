
package warrior;

import java.util.Scanner;

/**
 * This is the main class of the game.
 * The player can create a warrior, choose armor and weapon,
 * pick an opponent, and start a battle.
 */
public class Game {

    /**
     * Runs the game by allowing the player to create a warrior,
     * select equipment, choose an opponent and environment,
     * and participate in a battle.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name;
        String environmentType;
        int choice;
        int turn = 1;

        // Creates the warrior.
        System.out.println("WARRIOR");
        System.out.print("What should we call your warrior? ");

        name = input.nextLine();

        while (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Try again.");
            System.out.print("What should we call your warrior? ");
            name = input.nextLine();
        }

        Warrior warrior = new Warrior(name);

        // Allows the player to choose armor.
        System.out.println("\nPICK YOUR ARMOR");
        System.out.println("1. Light");
        System.out.println("2. Medium");
        System.out.println("3. Heavy");
        System.out.println("4. Blade");
        System.out.print("Which one do you want? ");

        choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Not a valid choice. Try again.");
            System.out.print("Which one do you want? ");
            choice = input.nextInt();
        }

        Armor armor;

        if (choice == 1) {
            armor = new LightArmor();
        }
        else if (choice == 2) {
            armor = new MediumArmor();
        }
        else if (choice == 3) {
            armor = new HeavyArmor();
        }
        else {
            armor = new BladeArmor();
        }

        warrior.equipArmor(armor);

        // Allows the player to choose a weapon.
        System.out.println("\nPICK YOUR WEAPON");
        System.out.println("1. Dagger");
        System.out.println("2. Sword");
        System.out.println("3. Battle Axe");
        System.out.println("4. Spear");
        System.out.println("5. Bow");
        System.out.print("What weapon will you use? ");

        choice = input.nextInt();

        while (choice < 1 || choice > 5) {
            System.out.println("Not a valid choice. Try again.");
            System.out.print("What weapon will you use? ");
            choice = input.nextInt();
        }

        Weapon weapon;

        if (choice == 1) {
            weapon = new Dagger();
        }
        else if (choice == 2) {
            weapon = new Sword();
        }
        else if (choice == 3) {
            weapon = new BattleAxe();
        }
        else if (choice == 4) {
            weapon = new Spear();
        }
        else {
            weapon = new Bow();
        }

        warrior.equipWeapon(weapon);

        // Allows the player to select an opponent.
        System.out.println("\nWHO WILL YOU FIGHT?");
        System.out.println("1. Thief");
        System.out.println("2. Viking");
        System.out.println("3. Minotaur");
        System.out.println("4. Cyclops");
        System.out.print("Choose your opponent: ");

        choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Not a valid choice. Try again.");
            System.out.print("Choose your opponent: ");
            choice = input.nextInt();
        }

        // Creates the selected opponent child class.
        Opponent opponent;

        if (choice == 1) {
            opponent = new Thief();
        }
        else if (choice == 2) {
            opponent = new Viking();
        }
        else if (choice == 3) {
            opponent = new Minotaur();
        }
        else {
            opponent = new Cyclops();
        }

        // Allows the player to select the battle environment.
        System.out.println("\nWHERE WILL YOU FIGHT?");
        System.out.println("1. Arena");
        System.out.println("2. Swamp");
        System.out.println("3. Colosseum");
        System.out.println("4. Lotus Eaters");
        System.out.print("Choose a location: ");

        choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Not a valid choice. Try again.");
            System.out.print("Choose a location: ");
            choice = input.nextInt();
        }

        if (choice == 1) {
            environmentType = "Arena";
        }
        else if (choice == 2) {
            environmentType = "Swamp";
        }
        else if (choice == 3) {
            environmentType = "Colosseum";
        }
        else {
            environmentType = "Lotus Eaters";
        }

        Environment environment = new Environment(environmentType);

        // Creates the battle.
        Battle battle = new Battle(warrior, opponent, environment);

        System.out.println("\nTHE BATTLE BEGINS!");
        System.out.println(
            warrior.getName() + " VS " + opponent.getName()
        );
        System.out.println(
            "Battle location: " + environment.getName()
        );

        // Repeats the battle until either fighter is defeated.
        while (warrior.isAlive() && opponent.isAlive()) {

            System.out.println("\nTURN " + turn);

            battle.startBattle();

            if (battle.checkWinner()) {
                break;
            }

            System.out.println(
                "\n" + warrior.getName() + " HP: " + warrior.getHP()
            );
            System.out.println(
                opponent.getName() + " HP: " + opponent.getHP()
            );

            System.out.println("\nWHAT WILL YOU DO?");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Charge");
            System.out.print("Enter your move: ");

            choice = input.nextInt();

            while (choice < 1 || choice > 3) {
                System.out.println("Choose only 1, 2, or 3.");
                System.out.print("Try again: ");
                choice = input.nextInt();
            }

            if (choice == 1) {

                System.out.println(
                    "\n" + warrior.getName() + " attacks!"
                );

                battle.attack();

            }
            else if (choice == 2) {

                System.out.println(
                    "\n" + warrior.getName()
                    + " takes a defensive stance!"
                );

                battle.defend();

            }
            else {

                System.out.println(
                    "\n" + warrior.getName() + " chooses to charge!"
                );

                battle.charge();

            }

            System.out.println("\nCURRENT HP");
            System.out.println(
                warrior.getName() + ": " + warrior.getHP()
            );
            System.out.println(
                opponent.getName() + ": " + opponent.getHP()
            );

            if (battle.checkWinner()) {
                break;
            }

            turn++;
        }

        System.out.println("\nTHAT'S THE END OF THE BATTLE!");

        input.close();
    }
}
