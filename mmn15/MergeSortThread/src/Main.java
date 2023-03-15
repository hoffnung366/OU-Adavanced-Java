/*
  This class represent a Multithreading Merge Sort

  @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of array members and the number of threads respectively.");
        // input from user
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] source = new int[n];
        // array initialization with random numbers in a range from 1 to 100
        for(int num, i = 0; i < n; i++) {
            num = (int)(Math.random()*100 + 1);
            source[i] = num;
        }

        Array arr = new Array(source);
        Merge[] threads = new Merge[m];

        // creating threads
        for(int i = 0; i < m; i++) {
            threads[i] = new Merge(arr);
        }

        for(int i = 0; i < m; i++) {
            threads[i].start();
        }

        for(int i = 0; i < m; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The array after sorting:\n" + arr);
    }
}
