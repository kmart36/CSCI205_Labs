/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/10/2021
 * Time: 9:36 AM
 *
 * Project: csci205_labs
 * Package: lab11.ex2.model
 * Class: Emitter
 *
 * Description:
 * Emitter class consisting of many references to the Particle class
 * ****************************************
 */
package lab11.ex2.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Emitter {
    // Particles will be emitted in random directions from the source
    private static Random rng = new Random();

    // Keep a list of the particles being emitted
    private List<Particle> listOfParticles;

    // Number of particles that will be emitted
    private int numParticles;

    // Position of the source of the emitter
    private double x, y;

    // Maximum velocity allowed in the pixels per second
    public static final double MAX_VELOCITY_PER_SEC = 150.0;

    // Maximum duration in seconds
    public static final double MAX_DURATION = 5.0;

    // List of colors
    public List<Color> colors;

    /**
     * Initializes the emitter object
     *
     * @param numParticles amount of particles in the emitter
     * @param x x-coordinate of the source of the emitter
     * @param y y-coordinate of the source of the emitter
     */
    public Emitter(int numParticles, double x, double y) {
        this.numParticles = numParticles;
        this.x = x;
        this.y = y;
        this.listOfParticles = new ArrayList<>();
        // Instantiating a list of colors from our ColorEnum values
        this.colors = new ArrayList<>();
        for (ColorEnum color : ColorEnum.values()) {
            this.colors.add(color.getColor());
        }
        this.initParticles();
    }

    /**
     * Initialize the set of particles that will be emitted from this emitter
     * durationInSec, xDeltaPerSec, and yDeltaPerSec are all generated randomly within the
     * constraints of our maximum values. These values are then used to make the particle
     * to add to the list.
     */
    private void initParticles() {
        while (listOfParticles.size() < this.numParticles) {
            double durationInSec = rng.nextDouble() * MAX_DURATION;
            double xDeltaPerSec = rng.nextDouble() * MAX_VELOCITY_PER_SEC - (MAX_VELOCITY_PER_SEC / 2);
            double yDeltaPerSec = rng.nextDouble() * MAX_VELOCITY_PER_SEC - (MAX_VELOCITY_PER_SEC / 2);
            // When making the particle, we'll get a random color from our color list in order
            // for our emitters to emit a rainbow of particles
            Particle p = new Particle(x, y, durationInSec, xDeltaPerSec, yDeltaPerSec, colors.get(rng.nextInt(6)));
            listOfParticles.add(p);
        }
    }

    // Return a Stream object representing a stream of particles
    public Stream<Particle> particleStream() { return this.listOfParticles.stream(); }

    // Go through each particle and start the timeline
    public void play() {
        particleStream().forEach(Particle::play);

    }

    //Go through each particle and stop and reset each
    public void stopAndReset() {
        particleStream().forEach(Particle::stopAndReset);
    }
}