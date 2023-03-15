/*
  This class represent a Monitor for Merge Threads

  @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Array {
    //instance variables
    private final Queue<int[]> arr;
    private final int length;

    //constructor
    /**
     * Divides specified array into a single member arrays and collect them in Queue
     * @param source - the source array
     */
    public Array(int[] source) {
        arr = new ConcurrentLinkedQueue<>();
        for(int n : source) {
            arr.add(new int[]{n});
        }
        length = source.length;
    }

    /**
     * Return sorted sub array into ArrayList
     * @param val - sorted sub array to be inserted
     */
    public synchronized void putData(int[] val) {
        arr.add(val);
        if(arr.size() == 2)
            notifyAll();
    }

    /**
     * Gets two sorted sub arrays to merge
     * @return two-dimension array with sub arrays to merge
     */
    public synchronized int[][] getData() {
        while((arr.size() < 2) && !isMergedDone()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int[][] temp = null;
        if(!isMergedDone()) {
            temp = new int[2][];
            temp[0] = arr.poll();
            temp[1] = arr.poll();
        }
        else {
            notifyAll();
        }

        return temp;
    }

   /**
    * Checks if merge sort is finished
    * @return true, if merge sort is finished
    */
    public synchronized boolean isMergedDone() {
        return (!arr.isEmpty() && arr.peek().length == length); // first element in collection contains all members
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                str.append(ints[j]).append(" ");
                if (j % 30 == 0 && j != 0)
                    str.append("\n");
            }
        }
        return str.toString();
    }
}