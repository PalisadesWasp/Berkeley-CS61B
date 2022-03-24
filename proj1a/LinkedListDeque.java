/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/proj/proj1a/proj1a
 * Project 1A: Data Structures
 * Implemented double ended queue using lists as the core data structure
 * Two sentinel approach was used here
 */

public class LinkedListDeque<T> {
    /**
     * Data structure for storing the item and the pointers
     */
    private class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        /**
         * Create a node with the specified parameters
         */
        TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private TNode front; // Front sentinel node
    private TNode rear; // Back sentinel node
    private int size; // Number of items in the deque

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque() {
        front = new TNode(null, null, null);
        rear = new TNode(null, front, null);
        front.next = rear;
        size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque
     */
    public void addFirst(T item) {
        TNode newNode = new TNode(item, front, null);
        newNode.next = front.next;
        front.next.prev = newNode;
        front.next = newNode;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    public void addLast(T item) {
        TNode newNode = new TNode(item, null, rear);
        newNode.prev = rear.prev;
        rear.prev.next = newNode;
        rear.prev = newNode;
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
        TNode currNode = front.next;
        while (currNode.item != null) {
            System.out.print(currNode.item);
            System.out.print(" ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        TNode firstNode = front.next;
        firstNode.next.prev = front;
        front.next = firstNode.next;
        size--;
        return firstNode.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        TNode lastNode = rear.prev;
        lastNode.prev.next = rear;
        rear.prev = lastNode.prev;
        size--;
        return lastNode.item;
    }

    /**
     * Gets the item at the given index
     * 0 is the front, 1 is the next item, and so forth
     * If no such item exists, returns null
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        TNode currNode = front.next;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.item;
    }

    /**
     * Helper method for implementing getRecursive
     * Gets the item at the given index, starting from node t
     */
    private T getRecursive(TNode t, int index) {
        if (index == 0) {
            return t.item;
        }
        return getRecursive(t.next, index - 1);
    }

    /**
     * Same as get, but uses recursion
     * Gets the item at the given index
     */
    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursive(front.next, index);
    }

}
