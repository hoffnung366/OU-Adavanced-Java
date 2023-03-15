/**
 * Main application class that loads and displays the DrawRandomShapes GUI
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class DrawRandomShapes extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DrawRandomShapes.fxml"));

        stage.setTitle("Draw Random Shapes");   //displayed in window's title bar
        stage.setScene(new Scene(root, 620, 450, Color.WHITE));   //attach scene to stage

        stage.show();   //display the stage
    }

    //application execution start here
    public static void main(String[] args) {
        launch(args);
    }
}

