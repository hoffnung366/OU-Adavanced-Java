import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.*;

import java.awt.event.MouseEvent;

public class GameController {
    // instance variables
    private GameLogic game;
    private double cellSize, margin;
    private GraphicsContext gc;

    public void add(MouseEvent event) {
        event.getX();
    }
    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        margin = 0;   // padding to the right that the matrix stayed centered
        game = new GameLogic();

        // checks which dimension is bigger to calculate cell size and marin
        if(canvas.getWidth() > canvas.getHeight()) {
            cellSize = canvas.getHeight() / GameLogic.MATRIX_SIZE;
            margin = (canvas.getWidth() - cellSize * GameLogic.MATRIX_SIZE) / 2;
        }
        else {
            cellSize = canvas.getWidth() / GameLogic.MATRIX_SIZE;
        }


        // draw first generation randomly
        for(int row = 0; row < GameLogic.MATRIX_SIZE; row++) {
            for(int col = 0; col < GameLogic.MATRIX_SIZE; col++) {
                // draw the cell according her position
                gc.strokeRect((margin + col * cellSize), (row * cellSize), cellSize, cellSize);
                // sets status LIVE for the cell when random number >= 0.5
                if(Math.random() >= 0.5) {
                    gc.fillRect((margin + col * cellSize), (row * cellSize), cellSize, cellSize);
                    game.setLiveCell(row, col);
                } // end of if
            } // end for -  one row
        } // end for - all rows
    } // end of method initialize

    // when user presses Next generation button, draw matrix with new generation
    @FXML
    public void nextGenerationButtonPressed(ActionEvent event){
        // Sets new status for all cells according to the rules of Conway's Game of Life
        game.setNextGeneration();

        // clear the canvas for next generation
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

        //draw next generation
        for(int row = 0; row < GameLogic.MATRIX_SIZE; row++) {
            for(int col = 0; col < GameLogic.MATRIX_SIZE; col++) {
                // draw the cell according her position
                gc.strokeRect((margin + col * cellSize), (row * cellSize), cellSize, cellSize);
                // checks if the cell is live
                if(game.getCell(row,col) == GameLogic.LIVE) {
                    gc.fillRect((margin + col * cellSize), (row * cellSize), cellSize, cellSize);
                } // end of if
            } // end for - one row
        } // end for - all rows
    } // end of method nextGenerationButtonPressed
} // end of class GameController
