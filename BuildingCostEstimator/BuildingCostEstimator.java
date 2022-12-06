/*
 * Course: CS1011_071
 *Fall 2020
 *Assignment Name Lab6
 *Name: cherise malisa
 *Created: 8/10/20
 */
package malisa;


public class BuildingCostEstimator {

    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private int squareFeet;
    private double numGarages;

    // constant price values for each house element
    final int COST_FULL_BATHS = 20000;
    final int COST_HALF_BATHS = 7000;
    final int COST_BEDROOM = 3000;
    final int COST_WINDOWS = 1000;
    final int COST_GARAGE_STALL = 8000;
    final int COST_SQUARE_FEET = 135;

    public void setNumFullBaths(int numFullBaths) {
        this.numFullBaths = numFullBaths;
    }

    public void setNumHalfBaths(int numHalfBaths) {
        this.numHalfBaths = numHalfBaths;

    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;

    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;

    }

    public void setNumGarages(double numGarages) {
        this.numGarages = numGarages;

    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    // calculate cost based on the number the user input
    public double costToBuild() {
        double costToBuild;
        costToBuild = (squareFeet * COST_SQUARE_FEET) + (numGarages * COST_GARAGE_STALL) +
                (numWindows * COST_WINDOWS) + (numBedrooms * COST_BEDROOM) +
                (numHalfBaths * COST_HALF_BATHS) + (numFullBaths * COST_FULL_BATHS);
        return costToBuild;

    }

    public void buildingCostEstimator() {

    }

    public int getNumFullBaths() {
        return numFullBaths;
    }

    public int getNumHalfBaths() {
        return numHalfBaths;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public double getNumGarages() {
        return numGarages;
    }

    public int getSquareFeet() {
        return squareFeet;
    }
}
