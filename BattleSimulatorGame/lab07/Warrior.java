/*
 * Course: CS1011
 * Fall 2019
 * Lab 7 - Battle Simulator 3000
 * Name:
 * Created:
 */
package lab07;


/**
 * warrior class were methods for warrior will be applied
 */
public class Warrior {

    private int hitPoints;
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d8 = new Die(8);
    private Die d4 = new Die(4);

    /**
     * warrior constructor used to initialize hit points
     */
    public Warrior() {
        this.hitPoints = setInitialHitPoints();

    }

    /**
     * returning current hit points
     *
     * @return hit points calculated
     */
    public int getHitPoints() {
        return hitPoints;
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
    }

    public int attack(int type) {
        int total = 0;
        if (type == 1) {
            d20.roll();
            if (d20.getCurrentValue() >= 12) {
                for (int x = 0; x < 2; x++) {
                    d8.roll();
                    total = d8.getCurrentValue();
                }
                System.out.println("You have wounded the mugwump with your trusty" +
                        "sword for " + total + "points of damage!");


            } else {
                System.out.println("You swing your sword and miss the foul creature!");
                return 0;
            }
        } else if (type == 2) {
            d20.roll();
            if (d20.getCurrentValue() >= 8) {
                d4.roll();
                total = d4.getCurrentValue();
                System.out.println("You struck the mugwump with your shield of light for " +
                        total + "points of damage!");

            } else {
                System.out.println("Your attempt to strike the mugwump failed");
                return 0;
            }

        }
        return total;
    }

    private int setInitialHitPoints() {
        int total = 0;
        for (int x = 0; x < 6; x++) {
            this.d10.roll();
            total += this.d10.getCurrentValue();
        }
        return total;

    }

}
