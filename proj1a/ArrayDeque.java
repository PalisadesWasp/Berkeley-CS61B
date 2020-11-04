public class ArrayDeque<T> {
    private T[] items;
    private int size; // Number of items in the deque
    private int frontIndex;
    private int rearIndex;
    private static final double USAGE_FACTOR = 0.25;
    private static final double RESIZE_FACTOR = 2;
    private static final int STARTING_SIZE = 8;
    private static final int MIN_LENGTH = 15;

    public ArrayDeque() {
        items = (T[]) new Object[STARTING_SIZE];
        size = 0;
        frontIndex = 0; // startingSize / 2
        rearIndex = STARTING_SIZE - 1; // startingSize / 2 - 1
    }

    public void addFirst(T item) {
        if (size == items.length) {
            int updatedSize = (int) (size * RESIZE_FACTOR) + 1;
            resize(updatedSize);
        }

        if (frontIndex - 1 < 0) {
            frontIndex = items.length - 1;
        } else {
            frontIndex--;
        }
        items[frontIndex] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            int updatedSize = (int) (size * RESIZE_FACTOR) + 1;
            resize(updatedSize);
        }

        if (rearIndex + 1 >= items.length) {
            rearIndex = 0;
        } else {
            rearIndex++;
        }
        items[rearIndex] = item;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int currIndex = frontIndex;
        for (int i = 0; i < size; i++) {
            System.out.print(items[currIndex]);
            System.out.print(" ");
            currIndex++;
            if (currIndex == items.length) {
                currIndex = 0;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T item = items[frontIndex];
            items[frontIndex] = null;
            if (frontIndex == items.length - 1) {
                frontIndex = 0;
            } else {
                frontIndex++;
            }
            size--;
            if ((double) size / items.length < USAGE_FACTOR && items.length > MIN_LENGTH) {
                int updatedSize = (int) (size * RESIZE_FACTOR) + 1;
                resize(updatedSize);
            }
            return item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T item = items[rearIndex];
            items[rearIndex] = null;
            if (rearIndex == 0) {
                rearIndex = items.length - 1;
            } else {
                rearIndex--;
            }
            size--;
            if ((double) size / items.length < USAGE_FACTOR && items.length > MIN_LENGTH) {
                int updatedSize = (int) (size * RESIZE_FACTOR) + 1;
                resize(updatedSize);
            }
            return item;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        } else if (frontIndex + index < items.length) {
            return items[frontIndex + index];
        } else {
            return items[frontIndex + index - items.length];
        }
    }

    private void resize(int capacity) {
        T[] newAD = (T[]) new Object[capacity];
        if (items.length == size || frontIndex > rearIndex) {
            System.arraycopy(items, frontIndex, newAD, 0, size - frontIndex);
            System.arraycopy(items, 0, newAD, size - frontIndex, frontIndex);
        } else {
            System.arraycopy(items, frontIndex, newAD, 0, size);
        }
        items = newAD;
        frontIndex = 0;
        rearIndex = size - 1;
    }

    /**
    public void printStatus() {
        System.out.println("length: " + items.length + "   usage: " + (double) size / items.length);
    }
     */

}
