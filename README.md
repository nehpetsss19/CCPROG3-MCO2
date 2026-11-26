# CCPROG3-MCO2
A Java-based Warrior Battle Game featuring opponent AI, weapon abilities, armor selection, battle environments, and a GUI built using Java Swing and the MVC architecture.

# Warrior Battle Game – MCO2

A Java-based Warrior Battle Game developed for **CCPROG3 (Object-Oriented Programming)** at De La Salle University.

This project expands the original Warrior Game by introducing opponent AI, weapon abilities, different armor types, battle environments, and a graphical user interface using Java Swing.

## Features

- **Warrior Customization** – Choose your warrior's armor and weapon.
- **Opponent AI** – Fight against different opponents with their own battle strategies.
- **Weapon Abilities** – Each weapon provides a special ability during combat.
- **Armor System** – Armor affects the warrior's defense and speed.
- **Battle Environments** – Fight in different environments with unique effects.
- **Turn-Based Combat** – Attack, defend, or charge during battles.
- **Graphical User Interface** – Interactive game interface built with Java Swing.

## Opponents

| Opponent | AI Behavior |
|---|---|
| Thief | Continuously attacks |
| Viking | Alternates between attacking and defending |
| Minotaur | Alternates between attacking and charging |

## Weapon Abilities

| Weapon | Special Ability |
|---|---|
| Dagger | Every other defend action guarantees an evade |
| Sword | Provides an additional 10 attack |
| Battle Axe | Charging provides additional attack and speed on the next turn |

## Armor Types

- Light Armor
- Medium Armor
- Heavy Armor

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming
- Model-View-Controller (MVC)
- Eclipse IDE

## Project Structure

```text
CCPROG3_MCO_2/
└── src/
    └── warrior/
        ├── Main.java
        ├── Game.java
        ├── Warrior.java
        ├── Opponent.java
        ├── Battle.java
        ├── Environment.java
        ├── Armor.java
        ├── Weapon.java
        ├── Fighter.java
        ├── WarriorView.java
        ├── WarriorController.java
        └── [Armor, Weapon, and Opponent subclasses]
```

## How to Run

1. Clone or download this repository.
2. Open Eclipse IDE.
3. Import the project into your workspace.
4. Make sure Java is properly configured.
5. Locate `Main.java` inside the `warrior` package.
6. Run `Main.java` to start the game.

## Concepts Applied

- Inheritance
- Polymorphism
- Method Overloading
- Method Overriding
- Encapsulation
- Model-View-Controller (MVC)
- Exception and Error Handling

## Developers
- Nucum, Mark Stephen M.
- Maglente, David Kyle
  
Developed as an academic Machine Problem (MCO2) for **CCPROG3 – Object-Oriented Programming**, De La Salle University.

---

*This project is an academic programming project.*
