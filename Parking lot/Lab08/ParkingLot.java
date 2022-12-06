/*
 * Course: CS1011
 * Fall 2019
 * Lab 7 - Battle Simulator 3000
 * Name: cherise malisa
 * Created:
 */
package malisa;

import java.text.DecimalFormat;


public class ParkingLot {
    public static final double CLOSED_THRESHOLD = 80.0;
    private final String name;
    private int capacity;
    private boolean status = false;
    private int spotsOpen, spotsOccupied;
    private int timeClosed, totalMinutesClosed, timeOpened;
    private int total;
    private int previousTime;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.name = "test";
        timeClosed = 0;
        total = 0;
    }

    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        timeClosed = 0;
        total = 0;
    }

    public void displayStatus() {
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.print("" + name + " parking lot status: ");
        if (getPercentFull() >= CLOSED_THRESHOLD) {
            System.out.println("CLOSED");
        } else {
            System.out.println(df.format(getPercentFull()) + "%");
        }

    }

    public int getMinutesClosed() {
        return total;

    }

    public String getName() {
        return this.name;
    }

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
}



