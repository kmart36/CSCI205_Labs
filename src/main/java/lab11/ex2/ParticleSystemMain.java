/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/10/2021
 * Time: 9:56 AM
 *
 * Project: csci205_labs
 * Package: lab11.ex2.model
 * Class: ParticleSystemMain
 *
 * Description:
 * Main class for the Particle System (this is the class that is called from the run command)
 * ****************************************
 */
package lab11.ex2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab11.ex2.model.ParticleSystemModel;

import java.io.IOException;

public class ParticleSystemMain extends Application {
    private ParticleSystemModel theModel;
    private ParticleSystemController theController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.theModel = new ParticleSystemModel();

        // Load in the FXML file. Obtain the root node of the scene graph
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/particlesim.fxml"));
        Parent root = loader.load();

        this.theController = loader.getController();
        this.theController.setModel(theModel);

        // Set up our stage
        primaryStage.setTitle("Particle Simulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}