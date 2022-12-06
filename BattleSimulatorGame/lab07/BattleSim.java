/*
 * Course: CS1011
 * Fall 2019
 * Lab 7 - Battle Simulator 3000
 * Name:
 * Created:
 */
package lab07;

import java.util.Scanner;

/**
 * BattleSim Driver for Battle Simulator 3000
 */
public class BattleSim {
    /**
     * Ten-sided die to be used for checking initiative by all classes
     */
    public static final Die INITIATIVE_DIE = new Die(10);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        boolean play = true; // sentinel value for the game loop
        String victor = ""; // String used to determine the winner of the epic battle
        // game loop
        do {
            intro(); // print the introduction and rules

            // Initialize the Warrior and Mugwump classes, set the current victor to "none"
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            victor = "none";

            // while neither combatant has lost all of their hit points, report status and battle!
            while (victor.equalsIgnoreCase("none")) {
                report(warrior, mugwump);
                victor = battle(warrior, mugwump, in);
                System.out.println("the victor is " + victor);
                victory(victor);
            }


            boolean again;
            //playAgain(input);
            // System.out.println("first ask");
            again = playAgain(input); // ask to play again
            play = again;
        } while (play);
        System.out.println("Thank you for playing the game!");
        // Thank the user for playing your game

    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {

        System.out.println("Welcome to Battle Simulator 3000!"
                + "The world's more low tech battle simulator!\n" +
                "You are a Valiant Warrior defending your humble village" +
                " from an evil Mugwump! Fight bravely, \n" +
                "or the citizens of your town will be the Mugwump's dinner!");

        System.out.println("\nYou have your Trusty Sword, which deals decent damage," +
                "but can be tough to hit with sometimes. \n" +
                "You also have your Shield of Light, which is not as strong as your sword," +
                "but is easier to deal \n" + "damage with.");

        System.out.println("\nLet the epic battle begin!");


    }

    /**
     * This method handles the battle logic for the game.
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first (Roll! For! Initiative!) and store the result
        int player1 = initiative();
        int warriorAttack;
        String victor = "none";

        while (mugwump.getHitPoints() > 0 && warrior.getHitPoints() > 0) {
            if (player1 == 1) {
                System.out.println("Warrior goes first!");
                warriorAttack = warrior.attack(attackChoice(in));
                mugwump.takeDamage(warriorAttack);
                report(warrior, mugwump);

                if (mugwump.getHitPoints() > 0) {
                    mugwump.attack();
                    warrior.takeDamage(mugwump.attack());
                    report(warrior, mugwump);
                }
            } else {
                System.out.println("\nMugwump goes first!");
                mugwump.attack();
                warrior.takeDamage(mugwump.attack());
                report(warrior, mugwump);

                if (warrior.getHitPoints() > 0) {
                    warriorAttack = warrior.attack(attackChoice(in));
                    mugwump.takeDamage(warriorAttack);
                    report(warrior, mugwump);
                }
            }
        }
        if (mugwump.getHitPoints() < 1) {
            victor = "warrior";
        } else if (warrior.getHitPoints() < 1) {
            victor = "mugwump";
        }

        return victor;
    }

    /**
     * This method reports the status of the combatants
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("warrior HP: " + warrior.getHitPoints());
        System.out.println("mugwump HP: " + mugwump.getHitPoints());

    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     *
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        int choice;

        System.out.println("How would you like to attack?\n" +
                "1. Your Trusty Sword\n2. Your Shield of Light" +
                "\nEnter choice:");

        choice = in.nextInt();
        System.out.println(choice);
        while (!(choice == 1 || choice == 2)) {
            System.out.println("How would you like to attack?\n" +
                    "1. Your Trusty Sword\n2. Your Shield of Light" +
                    "\nEnter choice:");

            choice = in.nextInt();
            System.out.println(choice);
        }

        return choice;

    }

    /**
     * Determines which combatant attacks first and returns the result. In the case of a tie,
     * re-roll.
     *
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        INITIATIVE_DIE.roll();
        int startwarrior = INITIATIVE_DIE.getCurrentValue();
        INITIATIVE_DIE.roll();
        int startmugwump = INITIATIVE_DIE.getCurrentValue();

        while (startmugwump == startwarrior) { // rolls again in the case of a tie
            INITIATIVE_DIE.roll();
            startwarrior = INITIATIVE_DIE.getCurrentValue();
            INITIATIVE_DIE.roll();
            startmugwump = INITIATIVE_DIE.getCurrentValue();
        }
        if (startmugwump > startwarrior) {
            return 1; // if initial roll for warrior is greater 1 is returned
        } else {
            return 2; // if initial roll for mugwump is greater, 2 is returned
        }

    }

    /**
     * This method declares the victor of the epic battle
     *
     * @param victor the name of the victor of the epic battle
     */
    private static void victory(String victor) {
        if (victor.equals("\nwarrior!")) {
            System.out.println("The citizens cheer and invite you back to town " +
                    "for a feast as thanks for saving their lives (again)!");
        } else if (victor.equals("\nmugwump")) {
            System.out.println("The mugwump has killed you " +
                    "and is making its way into the village !");
        }
    }

    /**
     * This method asks the user if they would like to play again
     *
     * @param input Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner input) {

        System.out.println("\nWould you like to play again? (yes/no)");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            return true;
        } else if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
            return false;
        }
        return false;
    }
}

