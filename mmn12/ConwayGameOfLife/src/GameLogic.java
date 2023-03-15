/**
 * This class represents the game logic which define the state of the cell
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 26/11/2021
 */

public class GameLogic {
    // class variables
    public static final int MATRIX_SIZE = 50;
    public static final int DEAD = 0;
    public static final int LIVE = 1;

    // instance variables
    private int[][] _matrix;

    //constructors
    /**
     * Constructs a matrix that represents grid for lives
     */
    public GameLogic() {
        _matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
    }

    /**
     * Sets the status "live" for the cell
     * @param row - indicate which row contain the cell
     * @param col - indicate which col contain the cell
     */
    public void setLiveCell(int row, int col) {
        _matrix[row][col] = LIVE;
    }

    /**
     * Returns the state of the cell
     * @param row - indicate which row contain the cell
     * @param col - indicate which col contain the cell
     * @return 1 for status LIVE and 0 for DEAD
     */
    public int getCell(int row, int col) {
        return _matrix[row][col];
    }

    /**
     * Sets new status for all cells according to the rules of Conway's Game of Life
     */
    public void setNextGeneration() {
        int temp[][] = new int[MATRIX_SIZE][MATRIX_SIZE];

        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int count, col = 0; col < MATRIX_SIZE; col++) {
                count = numNeighbours(row, col);     // counter of live neighbours

                // checks if a new status for the cell should be set
                if(_matrix[row][col] == DEAD && count == 3)
                    temp[row][col] = LIVE;
                else if(_matrix[row][col] == LIVE && !(count == 2 || count == 3))
                    temp[row][col] = DEAD;
                // the cell retains its state
                else
                    temp[row][col] = _matrix[row][col];
            } // end for - one row
        } // end for - all rows

        _matrix = temp;     // sets new generation
    } // end of method setNextGeneration

    //returns number of live neighbours
    //each cell has 8 neighbours, closed grid
    //the top border of the matrix is connected to the bottom, and the left border - to the right
    private int numNeighbours(int row, int col) {
        int above, under, left, right, last = MATRIX_SIZE - 1;

        above = (row == 0) ? last : (row - 1);
        under = (row == last) ? 0 : (row + 1);
        left = (col == 0) ? last : (col - 1);
        right = (col == last) ? 0 : (col + 1);

        return (_matrix[above][left] + _matrix[above][col] + _matrix[above][right] +
                _matrix[row][left] + _matrix[row][right] +
                _matrix[under][left] + _matrix[under][col] + _matrix[under][right]);
    } // end of method numNeighbours
} // end of class GameLogic
