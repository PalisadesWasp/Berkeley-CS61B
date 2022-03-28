/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/hw/hw1/hw1
 * HW 1: Packages, Interfaces, Generics, Exceptions, Iteration
 * Create a synthesizer package intended for use by programs that simulates the sound of instruments
 * using the Karplus-Strong algorithm
 */

package synthesizer;

/**
 * Uses an ArrayRingBuffer to implement the Karplus-Strong algorithm to synthesize a guitar
 * string sound
 */
//Make sure this class is public
public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency); // capacity = SR / frequency
        buffer = new ArrayRingBuffer<Double>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0); // buffer initially filled with zeros
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue(); // dequeue everything in the buffer
            buffer.enqueue(Math.random() - 0.5); // replace with random numbers btw -0.5 and 0.5
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double front = buffer.dequeue(); // dequeue the front sample
        double next = buffer.peek();
        // enqueue a new sample that is the average of the first two samples,
        // multiplied by the DECAY factor
        buffer.enqueue(DECAY / 2 * (front + next));
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
