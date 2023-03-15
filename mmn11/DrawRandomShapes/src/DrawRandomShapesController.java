import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class DrawRandomShapesController {
    @FXML
    private Canvas canvas;
    private final static int rectangle = 0;
    private final static int oval = 1;
    private final static int line = 2;

    // when user presses Draw Random Shapes button, draw random shapes in the Canvas
    // draws rectangle, oval or line based on random choice
    @FXML
    void drawRandomShapesButtonPressed() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Random random = new Random();
        int numOfShapes = 10;
        double maxWidth = canvas.getWidth() * 0.25;     // maximum 25% of canvas
        double maxHeight = canvas.getHeight() * 0.25;    // maximum 25% of canvas
        double shapeWidth, shapeHeight;
        double positionX, positionY;
        Color color;

        // clear the canvas for next set of shapes
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

        // draw 10 overlapping shapes
        for(int i = 0; i < numOfShapes; i++) {
            shapeWidth = random.nextDouble() * maxWidth;
            shapeHeight = random.nextDouble() * maxHeight;
            positionX = random.nextDouble() * canvas.getWidth();
            positionY = random.nextDouble() * canvas.getHeight();
            color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            gc.setFill(color);

            switch (random.nextInt(3)) {
                case rectangle:   // draw rectangle
                    gc.fillRect(positionX, positionY, shapeWidth, shapeHeight); break;
                case oval:    //draw oval
                    gc.fillOval(positionX, positionY, shapeWidth, shapeHeight); break;
                case line:    //draw line
                    gc.setStroke(color);
                    gc.strokeLine(positionX, positionY, (positionX + shapeWidth), (positionY + shapeHeight)); break;
            } // end of switch
        } // end of for loop
    } // end of drawRandomShapesButtonPressed method
} // end of drawRandomShapesController class