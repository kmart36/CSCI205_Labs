/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/10/2021
 * Time: 9:57 AM
 *
 * Project: csci205_labs
 * Package: lab11.ex2
 * Class: ParticleSystemController
 *
 * Description:
 * Controller class for the Particle System
 * ****************************************
 */
package lab11.ex2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import lab11.ex2.model.ParticleSystemModel;
import javafx.scene.control.ChoiceBox;


public class ParticleSystemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;

    @FXML
    private Canvas canvas;

    @FXML
    private CheckBox checkboxContinuous;

    @FXML
    private ChoiceBox<String> choiceBox;

    // A reference to the model this controller must work with
    private ParticleSystemModel theModel;

    // The Graphics Context of the canvas
    private GraphicsContext gc;

    // Our AnimationTimer object that will keep the canvas updating with cool stuff
    private AnimationTimer animationTimer;

    @FXML
    void initialize() {
        assert btnGenerate != null : "fx:id=\"btnGenerate\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert checkboxContinuous != null : "fx:id=\"checkboxContinuous\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'particlesim.fxml'.";
        this.gc = canvas.getGraphicsContext2D();
        choiceBox.setValue("Doge?");
        choiceBox.getItems().addAll("Doge?", "Rainbow?");
    }

    /**
     * Let's set our model instance that this controller is going to be referring to,
     * and we'll set up our event handlers and bindings here too.
     * @param theModel a reference to the {@link lab11.ex2.model.ParticleSystemModel} we're working with
     */
    public void setModel(ParticleSystemModel theModel) {
        this.theModel = theModel;

        // Generate a new random emitter
        this.btnGenerate.setOnAction(event -> {
            this.theModel.generateRandomEmitter((int)this.canvas.getWidth(), (int)this.canvas.getHeight());
        });

        //Set the start button handler
        this.btnStart.setOnAction(event -> {
            // If we already have an animation timer, then just stop the timeline and reset it to the beginning
            if (this.animationTimer != null) {
                this.theModel.stopAndReset();
            }
            else {
                // Creating a timer
                this.animationTimer = createAnimationTimer();
            }
            // Update the timeline to start playing
            this.theModel.play();

            // Start the animationTimer
            this.animationTimer.start();
        });

        // Stops the animationTimer
        this.btnStop.setOnAction(event -> this.animationTimer.stop());
    }

    private AnimationTimer createAnimationTimer() {
        return (new AnimationTimer() {
            @Override
            public void handle(long now) {
                GraphicsContext gc = ParticleSystemController.this.gc;
                ParticleSystemModel theModel = ParticleSystemController.this.theModel;

                // Clear the background every update
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, ParticleSystemController.this.canvas.getWidth(),
                        ParticleSystemController.this.canvas.getHeight());

                // Go through every particle of every emitter and draw an updated oval
                // based on its current position
                // Setting the GraphicsContext for the controller for each particle color
                // and oval in the position that the particle is generated to be in
                theModel.emitterStream()
                        .forEach(e -> e.particleStream()
                                .forEach(p -> {
                                    gc.setFill(p.getColor());
                                    // we made a choiceBox that allows the user to choose between rainbow particles or have them turn into a
                                    // popular internet meme known as "doge"
                                    if (choiceBox.getValue().equals("Rainbow?"))
                                        gc.fillOval(p.getX(), p.getY(), 3, 3);
                                    else
                                        gc.drawImage(p.getImage(), p.getX(), p.getY(), 15, 15);
                                }));
                // If the continuous checkbox is checked, this will go through each emitter and each particle in the emitter and will stop, reset, and play
                // the particle again when that particle's timeline is finished.
                if (checkboxContinuous.isSelected()) {
                    theModel.emitterStream()
                            .forEach(e -> e.particleStream()
                                    .forEach(p -> {
                                        p.getTimeline().setOnFinished(event -> {
                                            p.stopAndReset();
                                            p.play();
                                        });
                                    }));
                }
            }
        });
    }


}
