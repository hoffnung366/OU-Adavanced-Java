/*
  This class represent a Flight Thread

  @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */

import java.util.Random;

public class Flight extends Thread {
    // instance variables
    private final int numFlight;
    private final Airport departure, destination;

    /**
     * Allocates a new Thread object for specified flight
     * @param numFlight - number of the flight
     * @param departure - airport departure
     * @param destination - airport destination
     */
    public Flight(int numFlight, Airport departure, Airport destination) {
        this.numFlight = numFlight;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public void run() {
        int runwayFrom, runwayTo;
        //departure
        runwayFrom = departure.depart(numFlight);
        simulation(5000); // Simulates takeoff (range 1-5 sec)
        departure.freeRunway(numFlight, runwayFrom);
        simulation(10000); // Simulates flight (range 1-10 sec)

        //landing
        runwayTo = destination.land(numFlight);
        simulation(5000); // Simulates landing (range 1-5 sec)
        destination.freeRunway(numFlight, runwayTo);
    }

    // Sets the sleep time for the thread
    private void simulation(int maxTime) {
        Random gen = new Random();
        try {
            sleep(gen.nextInt(maxTime) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

