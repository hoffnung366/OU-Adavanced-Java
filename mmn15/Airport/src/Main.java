/*
  This class represent an Airport  Merge Sort

  @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */

public class Main {
    public static void main(String[] args) {
        final int N_FLIGHTS = 10;

        Airport newYork = new Airport("New York", 3);
        Airport telAviv = new Airport("Tel Aviv", 3);

        Flight[] flights = new Flight[N_FLIGHTS];

        Airport from, to;
        // creating random flight threads
        for(int i = 0; i < N_FLIGHTS; i++) {
            if(Math.random() >= 0.5) {
                from = newYork;
                to = telAviv;
            }
            else {
                from = telAviv;
                to = newYork;
            }
            flights[i] = new Flight((100+i), from, to);
        }

        for(int i = 0; i < N_FLIGHTS; i++) {
            flights[i].start();
        }
    }
}
