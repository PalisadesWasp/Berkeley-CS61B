/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/proj/proj1a/proj1a
 * Project 1A: Data Structures
 * Implemented double ended queue using arrays as the core data structure
 * Circular approach was used here
 */

public class ArrayDeque<T> {
    private T[] items;
    private int size; // Number of items in the deque
    private int frontIndex; // Index of the first item
    private int rearIndex; // Index of the last item
    private static final double UFACTOR_LIM = 0.25; // Usage factor should be at least this number
    private static final double RFACTOR = 2; // Increase the size to RFACTOR*size when deque is full
    private static final int STARTING_SIZE = 8; // The starting size of the deque
    private static final int MIN_LENGTH = 15; // Max length when usage factor can be arbitrarily low

    /**
     * Creates an empty array deque
     */
    public ArrayDeque() {
        items = (T[]) new Object[STARTING_SIZE];
        size = 0;
        frontIndex = 0;
        rearIndex = STARTING_SIZE - 1;
    }

    /**
     * Adds an item of type T to the front of the deque
     */
    public void addFirst(T item) {
        /* Expand the array when the deque is full */
        if (size == items.length) {
            int updatedSize = (int) (size * RFACTOR) + 1;
            resize(updatedSize);
        }
        /* Update the index of the first item */
        if (frontIndex - 1 < 0) {
            frontIndex = items.length - 1;
        } else {
            frontIndex--;
        }
        items[frontIndex] = item;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    public void addLast(T item) {
        /* Expand the array when the deque is full */
        if (size == items.length) {
            int updatedSize = (int) (size * RFACTOR) + 1;
            resize(updatedSize);
        }
        /* Update the index of the last item */
        if (rearIndex + 1 >= items.length) {
            rearIndex = 0;
        } else {
            rearIndex++;
        }
        items[rearIndex] = item;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of items in the deque
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space
     */
    public void printDeque() {
        /* Printing the items starting from the front of the deque */
        int currIndex = frontIndex;
        for (int i = 0; i < size; i++) {
            System.out.print(items[currIndex]);
            System.out.print(" ");
            currIndex++;
            /* Circle back when reach the end of the array */
            if (currIndex == items.length) {
                currIndex = 0;
            }
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            /* Remove the first item if the deque is not empty */
            T item = items[frontIndex];
            items[frontIndex] = null;
            if (frontIndex == items.length - 1) {
                frontIndex = 0; // Circle back to the front if already reached the end of the array
            } else {
                frontIndex++;
            }
            size--;
            /* Shorten the array if the usage factor is too low */
            if ((double) size / items.length < UFACTOR_LIM && items.length > MIN_LENGTH) {
                int updatedSize = (int) (size * RFACTOR) + 1;
                resize(updatedSize);
            }
            return item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            /* Remove the last item if the deque is not empty */
            T item = items[rearIndex];
            items[rearIndex] = null;
            if (rearIndex == 0) {
                // Circle back to the rear if already reached the start of the array
                rearIndex = items.length - 1;
            } else {
                rearIndex--;
            }
            size--;
            /* Shorten the array if the usage factor is too low */
            if ((double) size / items.length < UFACTOR_LIM && items.length > MIN_LENGTH) {
                int updatedSize = (int) (size * RFACTOR) + 1;
                resize(updatedSize);
            }
            return item;
        }
    }

    /**
     * Gets the item at the given index
     * 0 is the front, 1 is the next item, and so forth
     * If no such item exists, returns null
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        } else if (frontIndex + index < items.length) {
            return items[frontIndex + index];
        } else {
            // Circle back when reach the end of the array
            return items[frontIndex + index - items.length];
        }
    }

    /**
     * Resize the array to the specified length
     */
    private void resize(int capacity) {
        T[] newAD = (T[]) new Object[capacity];
        if (frontIndex > rearIndex) {
            /* If (1) expand the deque, or (2) shorten the deque when the deque is at the two
             *  ends of the array: first copy the deque from its front to the end of the array,
             *  and then circle back to the start of the array and copy the remaining items */
            System.arraycopy(items, frontIndex, newAD, 0, items.length - frontIndex);
            System.arraycopy(items, 0, newAD, size - frontIndex, size - items.length + frontIndex);
        } else {
            /* If shorten the deque when the deque is at the middle of the array:
             * copy the whole deque directly */
            System.arraycopy(items, frontIndex, newAD, 0, size);
        }
        items = newAD;
        frontIndex = 0;
        rearIndex = size - 1;
    }

    /**
     * Helper function for testing; print the length of the array and the usage factor
     */
    /*public void printStatus() {
        System.out.println("length: " + items.length + "   usage: " + (double) size / items.length);
    }*/

}
