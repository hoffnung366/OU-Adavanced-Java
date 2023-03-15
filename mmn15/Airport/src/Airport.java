/*
  This class represent a Monitor for Flight Threads

  @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Airport {
    // instance variables
    private final String name;
    private final Queue<Integer> flights;
    private final Queue<Integer> availableRunways;

    /**
     * Creates an airport object
     * @param name - name of the airport
     * @param nRunways - number of runways in the airport
     */
    public Airport(String name, int nRunways) {
        this.name = name;
        flights = new ConcurrentLinkedQueue<>();
        availableRunways = new ConcurrentLinkedQueue<>();
        for(int i = 1; i <= nRunways; i++)
            availableRunways.add(i);
    }

    /**
     * Receives the flight number requesting to take off and returns a free runway number
     * @param numFlight - number of specified flight
     * @return - a runway number to take off
     */
    public synchronized int depart(int numFlight) {
        flights.add(numFlight);
        System.out.println("Flight number " + numFlight + " is asking for departing from " + name + " airport.");
        return getPath(numFlight, "departing from");
    }

    /**
     * Receives the number of the flight requesting to land and returns a free runway number
     * @param numFlight - number of specified flight
     * @return - a runway number to land
     */
    public synchronized int land(int numFlight) {
        flights.add(numFlight);
        System.out.println("Flight number " + numFlight + " is asking for landing to " + name + " airport.");
        return getPath(numFlight, "landing to");
    }

    /**
     * Releases a runway that was used for takeoff or landing.
     * @param numFlight - number of specified flight
     * @param numRunway - number of runway that was freed
     */
    public synchronized void freeRunway(int numFlight, int numRunway) {
        availableRunways.add(numRunway);
        System.out.println("Flight number " + numFlight + " freed the path #" + numRunway + " in " + name + " airport.");
        notifyAll();
    }

    // Checks if available runway exists and return his number
    // If there are no available runways or if it is not this flight turn to take off/land, than put thread to waiting
    private int getPath(int numFlight, String status) {
        while(availableRunways.isEmpty() || (!flights.isEmpty() && (flights.peek() != numFlight))){
            try {
                System.out.println("Flight number " + numFlight + " " + status + " " + name + " are waiting for a path.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Flight number " + numFlight + " " + status + " " + name + ", the path #" + availableRunways.peek());
        flights.poll();
        int numRunway = availableRunways.poll();
        notifyAll();
        return numRunway;
    }
}
