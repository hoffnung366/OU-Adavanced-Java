/**
 * This class represent a Merge Thread
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 22/01/2022
 */
public class Merge extends Thread {
    private final Array source;

    /**
     * Allocates a new Thread object for sorting specified array
     * @param source - array that need to be sort
     */
    public Merge(Array source) {
        this.source = source;
    }

    @Override
    public void run() {
        int[][] array;
        while((array = source.getData()) != null) {
            source.putData(getMerged(array[0], array[1]));
        }
    }

    /**
     * Returns sorted array after merge two specified arrays
     * @param left - the first sorted array to merge
     * @param right - the second sorted array to merge
     * @return - sorted array after merge two specified arrays
     */
    public int[] getMerged(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for(int i = 0, j = 0, k = 0; k < res.length; k++) {
            if(j >= right.length || (i < left.length && left[i] <= right[j]))
                res[k] = left[i++];
            else
                res[k] = right[j++];
        }
        return res;
    }
}