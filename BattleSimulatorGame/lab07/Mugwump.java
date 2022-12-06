/*
 * Course: CS1011
 * Fall 2019
 * Lab 7 - Battle Simulator 3000
 * Name:
 * Created:
 */
package lab07;

public class Mugwump {

    private int hitPoints;
    private int maxHitPoints;
    private Die d100 = new Die(100);
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d6 = new Die(6);

    /**
     * initializing starting hit points for mugwump
     */
    public Mugwump() {
        maxHitPoints = setInitialHitPoints();
        hitPoints = maxHitPoints;

    }

    /**
     * method used to access hit points of mugwump
     *
     * @return the current hit points after rounds
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * taking the hits from the mugwump deducting HP
     *
     * @param damage returns deducts damage done by mugwump
     */
    public void takeDamage(int damage) {
        hitPoints -= damage;
    }


    /**
     * This method handles the attack logic
     *
     * @return the amount of damage an attack has caused, 0 if the attack misses or
     * a negative amount of damage if the Mugwump heals itself
     */
    public int attack() {
        int total = 0;
        // get attack type from ai
        int attack = ai();
        // roll attack die
        if (attack == 1) {
            d20.roll();
            if (d20.getCurrentValue() >= 12) {
                for (int i = 0; i < 2; i++) {
                    d6.roll();
                    total = d6.getCurrentValue();
                }
                System.out.println("Mugwump rips you apart with its razor sharp claws!" +
                        " and hurts you by " + total + "points");
                return total;
            } else {
                System.out.println("Mugwump tries to rip you apart with" +
                        "its razor sharp claws and misses");
                return 0;
            }

        } else if (attack == 2) {
            d20.roll();
            if (d20.getCurrentValue() >= 16) {
                for (int i = 0; i < 3; i++) {
                    d6.roll();
                    total = d6.getCurrentValue();
                }
                System.out.println("The mugwump snaps at you with its fangs!" +
                        "for " + total + " points for damage");
                return total;
            } else {
                System.out.println("The mugwump snaps at you and misses!");
            }
            return 0;
        } else if (attack == 3) {
            System.out.println("The mugwump licks his or her wounds and heals!");
            d6.roll();
            total = d6.getCurrentValue();
            if (hitPoints < maxHitPoints) {
                this.hitPoints += total;
            }
        }
        return 0;
    }

    /**
     * method rolls 10 dice for mugwump
     *
     * @return the value on those dice added up to be initial
     */
    public int setInitialHitPoints() {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            d10.roll();
            total += d10.getCurrentValue();
        }

        return total;
    }

    /**
     * This method determines what action the Mugwump performs
     *
     * @return 1 for a claw attack , 2 for a bite , and 3 if the mugwump licks its wounds
     */
    private int ai() {
        d100.roll();
        if (d100.getCurrentValue() <= 10) {
            return 3;
        }
        if (d100.getCurrentValue() > 10 && d100.getCurrentValue() <= 25) {
            return 2;
        } else {
            return 1;
        }
    }
}


