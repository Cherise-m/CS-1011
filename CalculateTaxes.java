/*

 */
package malisac;

import java.util.Scanner;
import java.text.DecimalFormat;


public class CalculateTaxes {
    public static void main(String[] args) {
        String status;
        char userStatus;
        double earnedIncome, estimatedTax = 0.0, effectiveTax; // all these are variables declared as floats
        Scanner in = new Scanner(System.in);

        System.out.println("Are you a single filer or a married joint filer (enter 's' or 'j')");
        status = in.nextLine();  // users status from keyboard
        userStatus = status.charAt(0); // reference to  the character entered by user
        System.out.println("Enter an estimate of your earned income for 2019");
        earnedIncome = in.nextFloat();// takes user values from keyboard and puts it in earned income variable

        DecimalFormat decimals = new DecimalFormat("#,###,###.00");// to shorten calculated output to 2dp

        while (userStatus == 's') { // will only run what's in the curly brackets if the user status is s


            if (earnedIncome >= 0 && earnedIncome <= 9700) {
                estimatedTax = (0.10 * earnedIncome);
            } else if (earnedIncome >= 9701 && earnedIncome <= 39_475) {
                estimatedTax = (0.10 * 9700) + (0.12 * (earnedIncome - 9700));
            } else if (earnedIncome >= 39_476 && earnedIncome <= 84_200) {
                estimatedTax = (0.10 * 9700) + (0.12 * 29_775) + (0.22 * (earnedIncome - 39_475));
            } else if (earnedIncome >= 84_201 && earnedIncome <= 160_725) {
                estimatedTax = (0.10 * 9700) + (0.12 * 29_775) + (0.22 * 44_725) + ((earnedIncome - 84_200) * 0.24);
            } else if (earnedIncome >= 160_726 && earnedIncome <= 204_100) {
                estimatedTax = (0.10 * 9700) + (0.12 * 29_775) + (0.22 * 44_725) + (0.24 * 76_525) + ((earnedIncome - 160_725) * 0.32);
            } else if (earnedIncome >= 204_101 && earnedIncome <= 510_300) {
                estimatedTax = (0.10 * 9700) + (0.12 * 29_775) + (0.22 * 44_725) + (0.24 * 76_525) + (0.32 * 43_375 + ((earnedIncome - 204_100) * 0.35));
            } else if (earnedIncome >= 510_301) {
                estimatedTax = (0.01 * 9700) + (0.12 * 29_775) + (0.22 * 44_725) + (0.24 * 76_525) + (0.32 * 43_375) + (0.35 * 306_200) + ((earnedIncome - 510_300) * 0.37);
            }
            userStatus = 'f'; // to terminate the loop
        }


        while (userStatus == 'j') { // will only run what is after the bracket if the user status entered is j

            if (earnedIncome > 0 && earnedIncome <= 19_400) {
                estimatedTax = (0.1 * earnedIncome);
            } else if (earnedIncome >= 19_401 && earnedIncome <= 78_950) {
                estimatedTax = (0.1 * 19_400) + (0.12 * (earnedIncome - 19_400));
            } else if (earnedIncome >= 78_951 && earnedIncome <= 168_400) {
                estimatedTax = (0.1 * 19_400) + (0.12 * 59_550) + ((earnedIncome - 78_950) * 0.22);
            } else if (earnedIncome >= 168_401 && earnedIncome >= 321_450) {
                estimatedTax = (0.1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + ((earnedIncome - 168_400) * 0.24);
            } else if (earnedIncome >= 321_451 && earnedIncome <= 408_200) {
                estimatedTax = (0.1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * 153_050) + ((earnedIncome - 321_450) * 0.32);
            } else if (earnedIncome >= 408_201 && earnedIncome <= 612_350) {
                estimatedTax = (0.1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * 153_050) + (0.32 * 86_750) + ((earnedIncome - 408_200) * 0.35);
            } else if (earnedIncome >= 612_351) {
                estimatedTax = (0.1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * 153_050) + (0.32 * 86750) + (0.35 * 204_150) + ((earnedIncome - 612_351) * 0.37);
            }
            userStatus = 'g';// to terminate the married loop
        }

        System.out.println("Your estimated taxes for 2019 are:$ " + decimals.format(estimatedTax));
        effectiveTax = (estimatedTax / earnedIncome) * 100;
        System.out.println("Your income tax is, " + decimals.format(effectiveTax) + " percent");
    }
}


