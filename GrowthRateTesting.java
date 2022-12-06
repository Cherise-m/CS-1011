/*
Course: CS1011_071
Fall 2020
Assignment Name
Name: cherise malisa
Created: 8/10/20
*/

import java.util.Scanner;

public class GrowthRateTesting {
    public static void main(String[] args) {

        int choice, playAgain, numberOfWeeks;
        double linear, exponential;

        double startingAmount = 5000 * (Math.random());// initialising the linear option with the random generated number
        numberOfWeeks = (int) (40 * (Math.random()));// initializing number of weeks to a random number

        choice = 1;
        linear = startingAmount;
        exponential = 0.01;
        linear = linear + startingAmount;
        exponential = exponential * 2;

        while (exponential > linear) {
            for (int i = 0; i < numberOfWeeks; i++) {

                linear = linear + startingAmount;
                exponential = exponential * 2;

            }
            double difference = Math.abs(exponential - linear);
            if (choice == 1) {
                System.out.println("You lost the game :( ,and missed out on $ " + difference);
            }
            if (choice == 2) {
                System.out.println("You won the game!!, and have an extra of $ " + difference);
            }
        }

    }
}
