/**
 * Main application class that loads and displays the Conway's Game of Life GUI
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));

        stage.setTitle("Conway's Game of Life");   //displayed in window's title bar
        stage.setScene(new Scene(root, 600, 500, Color.WHITE));   //attach scene to stage

        stage.show();   //display the stage
    }

    //application execution start here
    public static void main(String[] args) {
        launch(args);
    }
}
