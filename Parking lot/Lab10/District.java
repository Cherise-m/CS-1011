/*
 * Course: CS1011
 * Fall 2019
 * Lab 9 - District
 * Name: Cherise Malisa
 * Created: 16/11/2020
 */

package Lab10;


import java.util.ArrayList;

/**
 * Manages parking lots within a district.
 *
 * @author cherise malisa
 */
public class District {
    private int numLots;
    ArrayList<ParkingLot> lots;

    private int timeClosed;
    private int timeOpened;
    private int totalTimeClosed;
    private int previousTime;
    private int total;

    /**
     * constructor where number of lots is initialized
     * an array of lots is initialised as well
     */
    public District() {
        numLots = 0;
        lots = new ArrayList<>();
    }

    /**
     * adding lots
     *
     * @param name     name of lot passed in
     * @param capacity size of lot
     * @return size of lots
     */
    public int addLot(String name, int capacity) {
        lots.add(new Lab10.ParkingLot(name, capacity));
        numLots++;

        return lots.size() - 1;
    }

    /**
     * method that adds parking lots to the district
     *
     * @param index position in arraylist
     * @return index of the lot lot in the district
     */
    public ParkingLot getLot(int index) {
        if (index >= 0 && index <= lots.size()) {
            return lots.get(index);
        }
        return null;
    }

    /**
     * Returns the number of remaining parking spots in the district
     *
     * @return the number of remaining parking spots in the district
     */
    public int getNumberOfSpotsRemaining() {
        int spotsOpen = 0;
        for (int g = 0; g < numLots; g++) {

            spotsOpen += lots.get(g).getNumberOfSpotsRemaining();
        }
        return spotsOpen;
    }

    /**
     * Returns the amount of time all three lots have been
     * simultaneously closed.
     *
     * @return number of minutes all three lots have been closed
     */
    public int getMinutesClosed() {
        return total;
    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     *
     * @return whether all three lots in the district are closed
     */
    public boolean isClosed() {
        int numClosed = 0;
        for (int g = 0; g < numLots; g++) {
            if (lots.get(g).isClosed()) {
                numClosed += 1;
                if (numClosed == numLots) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Record a vehicle entering a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on lot1).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     *
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            lots.get(lotNumber).markVehicleEntry(timeClosed);

            if (isClosed() && !alreadyClosed) {
                timeClosed = timestamp;
            }
            previousTime = timestamp;
        }
    }

    /**
     * Record a vehicle exiting a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleExit for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleExit on lot1).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     *
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param timestamp Exit timestamp in minutes since all lots were opened.
     */
    public void markVehicleExit(int lotNumber, int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            lots.get(lotNumber).markVehicleExit(timeOpened);
            timeOpened = timestamp;
            if (!(isClosed()) && alreadyClosed) {
                totalTimeClosed = timeOpened - timeClosed;
                total += totalTimeClosed;
            }
        }
        previousTime = timestamp;

    }

    /**
     * format for the wanted output
     *
     * @return output statement
     */
    public String toString() {
        String outputStatement = "";

        outputStatement += "District status:\n";
        for (int i = 0; i < numLots; i++) {
            outputStatement += "  " + lots.get(i).toString() + "\n";
        }
        return outputStatement;
    }
}
