package synthesizer;
import java.util.Iterator;

/**
 * An interface that defines a queue structure, which allows items to only be enqueued at the back
 * of the queue, and only be dequeued from the front of the queue
 * The BoundedDeque has a fixed capacity, and nothing is allowed to enqueue if the queue is full
 */
public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    default boolean isEmpty() {
        return fillCount() == 0; // check if the buffer is empty
    }

    default boolean isFull() {
        return fillCount() == capacity(); // check if the buffer is full
    }

    @Override
    Iterator<T> iterator();
}
