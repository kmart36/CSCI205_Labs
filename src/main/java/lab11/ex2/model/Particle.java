/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/8/2021
 * Time: 7:20 PM
 *
 * Project: csci205_labs
 * Package: lab11.ex2
 * Class: Particle
 *
 * Description:
 * Particle class
 * ****************************************
 */
package lab11.ex2.model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Particle {

    /** The current x-coordinate of the particle */
    private final DoubleProperty x;

    /** The current y-coordinate of the particle */
    private final DoubleProperty y;

    /** The color of the particle */
    private final Color color;

    /** The Timeline object that JavaFX provides to help auto update the particle */
    private Timeline timeline;

    private Image image = new Image("/Doge.jpg");

    /**
     * Initialize a new particle
     *
     * @param startX starting x-coordinate
     * @param startY starting y-coordinate
     * @param duration how long should this particle stay alive?
     * @param xDeltaPerSec the update amount of the x-coordinate
     * @param yDeltaPerSec the update amount of the y-coordinate
     * @param color the color of the particle
     */
    public Particle(double startX, double startY, double duration, double xDeltaPerSec,
                    double yDeltaPerSec, Color color) {
        this.x = new SimpleDoubleProperty();
        this.y = new SimpleDoubleProperty();
        this.color = color;
        this.initTimeline(startX, startY, duration, xDeltaPerSec, yDeltaPerSec);
    }
    /**
     * This initializes a new timeline to allow a particle to move over time
     *
     * @param startX the starting x-coordinate for the particle
     * @param startY the starting y-coordinate for the particle
     * @param duration the number of seconds the particle should remain alive
     * @param xDeltaPerSec the change in x-coordinate per second
     * @param yDeltaPerSec the change in y-coordinate per second
     */
    private void initTimeline(double startX, double startY, double duration,
                              double xDeltaPerSec, double yDeltaPerSec) {
        this.timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(x, startX),
                        new KeyValue(y, startY)
                ),
                new KeyFrame(Duration.seconds(duration),
                        new KeyValue(x, startX + (xDeltaPerSec * duration)),
                        new KeyValue(y, startY + (yDeltaPerSec * duration))
                )
        );
    }

    /**
     * Start the timeline animation
     */
    public void play() { this.timeline.play(); }

    /**
     * Pause the timeline animation
     */
    public void pause() { this.timeline.pause(); }

    /**
     * Stop the current animation and reset the timeline back to the beginning
     */
    public void stopAndReset() { this.timeline.stop(); }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public Image getImage() { return this.image; }

}