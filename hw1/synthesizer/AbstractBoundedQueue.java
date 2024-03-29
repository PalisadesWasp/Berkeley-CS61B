package synthesizer;

/**
 * An abstract class that implements BoundedQueue, capturing the redundancies between methods
 * in BoundedQueue
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount; // number of items currently in the buffer
    protected int capacity; // size of the buffer

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }
}
