/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/hw/hw1/hw1
 * HW 1: Packages, Interfaces, Generics, Exceptions, Iteration
 * Create a synthesizer package intended for use by programs that simulates the sound of instruments
 * using the Karplus-Strong algorithm
 */

package synthesizer;
import java.util.Iterator;

/**
 * A class that extends AbstractBoundedQueue, and uses an array as the actual implementation of
 * the BoundedQueue, with the ‘ring buffer’ data structure
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if (fillCount == capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount++;
        if (last + 1 == capacity) {
            last = 0;
        } else {
            last++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T front = rb[first];
        rb[first] = null;
        fillCount--;
        if (first + 1 == capacity) {
            first = 0;
        } else {
            first++;
        }
        return front;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new arrayIterator();
    }

    /**
     * Iterator implementation
     */
    private class arrayIterator implements Iterator<T> {
        private int ptr;
        private int count;

        public arrayIterator() {
            ptr = first;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return (count != fillCount);
        }

        @Override
        public T next() {
            T returnItem = rb[ptr];
            if (ptr + 1 == capacity) {
                ptr = 0;
            } else {
                ptr++;
            }
            count++;
            return returnItem;
        }
    }
}
