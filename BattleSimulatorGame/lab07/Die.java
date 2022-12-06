/*
 * Course: CS1011
 * Fall 2019
 * Lab 7 - Battle Simulator 3000
 * Name:
 * Created:
 */
package lab07;

import java.util.Random;

/**
 * class were different sided are rolled
 */
public class Die {
    private int numSides;
    private int currentValue;
    private Random generator = new Random();
    final int MAX_VALUE = 100;
    final int DEFAULT_VALUE = 6;

    public Die(int numSides) {
        if (numSides >= 2 && numSides <= MAX_VALUE) {
            this.numSides = numSides;
        } else {
            this.numSides = DEFAULT_VALUE;
        }
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public void roll() {
        currentValue = generator.nextInt(numSides) + 1;

    }

}
