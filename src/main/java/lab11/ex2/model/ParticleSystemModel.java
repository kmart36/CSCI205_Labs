/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/10/2021
 * Time: 9:46 AM
 *
 * Project: csci205_labs
 * Package: lab11.ex2.model
 * Class: ParticleSystemModel
 *
 * Description:
 * Model class for the Particle System
 * ****************************************
 */
package lab11.ex2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParticleSystemModel {

    // Default number of particles for each emitter if not specified
    public static final int DEF_NUM_PARTICLES = 120;

    // A shared number generator
    private final Random rng = new Random();

    // A list of emitters in our particle system
    private List<Emitter> listOfEmitters;


    public ParticleSystemModel() {
        this.listOfEmitters = new ArrayList<>();
    }

    // Return a Stream view of the list of emitters
    public Stream<Emitter> emitterStream() {
        return this.listOfEmitters.stream();
    }

    /**
     * Add a new emitter that will produce a specified number of particles
     * @param x the x-coordinate of the emitter
     * @param y the y-coordinate of the emitter
     * @param numParticles number of particles that will be emitted
     */
    public void addNewEmitter(int x, int y, int numParticles) {
        Emitter emitter = new Emitter(numParticles, x, y);
        this.listOfEmitters.add(emitter);
    }

    /**
     * Generate an emitter at a random location
     *
     * @param maxWidth maximum x-coordinate to allow
     * @param maxHeight maximum y-coordinate to allow
     * @param numParticles number of particles to emit
     */
    public void generateRandomEmitter(int maxWidth, int maxHeight, int numParticles) {
        int x = rng.nextInt(maxWidth);
        int y = rng.nextInt(maxHeight);
        this.addNewEmitter(x, y, numParticles);
    }

    public void generateRandomEmitter(int maxWidth, int maxHeight) {
        this.generateRandomEmitter(maxWidth, maxHeight, DEF_NUM_PARTICLES);
    }

    public void play() {
        emitterStream().forEach(emitter -> emitter.play());
    }

    public void stopAndReset() {
        emitterStream().forEach(emitter ->  emitter.stopAndReset());
    }

}