/*
 * Course: CS1011
 * Fall 2019
 * Lab 9 - Parking Lot
 * Name: Cherise Malisa
 * Created: 12/05/2020
 */
package week.Lab09;

import java.text.DecimalFormat;

/**
 * keeps track of activity in each parking lot
 */
public class ParkingLot {

    DecimalFormat df = new DecimalFormat("#.#");

    /**
     * maximum capacity that is reached for lot to close
     */
    public static final double CLOSED_THRESHOLD = 80.0;
    private final String name;
    private int capacity;
    private boolean status = false;
    private int spotsOpen, spotsOccupied;
    private int timeClosed, totalMinutesClosed, timeOpened;
    private int total;
    private int previousTime = 0;

    /**
     * first constructor
     *
     * @param capacity is passed in from the lots driver
     */
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.name = "test";
        timeClosed = 0;
        total = 0;
    }

    /**
     * second constructor where some variables are initialized
     *
     * @param name     is passed in from lots driver for a particular lot
     * @param capacity is passed in from lots driver for a particular lot
     */
    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        timeClosed = 0;
        total = 0;
    }


    public int getMinutesClosed() {
        return total;

    }

    public String getName() {
        return this.name;
    }

    /**
     * calculates how many spots are available at certain times in a parking lot
     *
     * @return the number of spots open
     */
    public int getNumberOfSpotsRemaining() {
        spotsOpen = this.capacity - this.spotsOccupied;
        return spotsOpen;
    }

    public double getPercentFull() {
        return ((double) this.spotsOccupied / (double) this.capacity) * 100;
    }

    /**
     * closes the gate when percent full reaches threshold
     *
     * @return true to close the gate and false otherwise
     */
    public boolean isClosed() {
        if (getPercentFull() >= CLOSED_THRESHOLD) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public void markVehicleEntry(int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            spotsOccupied += 1;
            if (getPercentFull() >= CLOSED_THRESHOLD) {
                status = true;
                if (status && !alreadyClosed) {
                    timeClosed = timestamp;
                }
            }
            previousTime = timestamp;
        }
    }


    public void markVehicleExit(int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();

        if (previousTime <= timestamp) {

            timeOpened = timestamp;
            spotsOccupied -= 1;

            if (!(isClosed()) && alreadyClosed) {
                totalMinutesClosed = timeOpened - timeClosed;
                total += totalMinutesClosed;
            }
        }
    }

    public String toString() {
        String display;

        display = "Status for " + name + " parking lot: " +
                spotsOccupied + " vehicles (" + df.format(getPercentFull()) + "%)";
        if (getPercentFull() >= CLOSED_THRESHOLD) {
            display = "Status for " + name + " parking lot: "
                    + spotsOccupied + " vehicles (CLOSED)";
        }
        return display;
    }
}
