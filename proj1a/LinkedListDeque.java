public class LinkedListDeque<T> {

    private class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private TNode front;
    private TNode rear;
    private int size;

    public LinkedListDeque() {
        front = new TNode(null, null, null);
        rear = new TNode(null, front, null);
        front.next = rear;
        size = 0;
    }

    public void addFirst(T item) {
        TNode newNode = new TNode(item, front, null);
        newNode.next = front.next;
        front.next.prev = newNode;
        front.next = newNode;
        size++;
    }

    public void addLast(T item) {
        TNode newNode = new TNode(item, null, rear);
        newNode.prev = rear.prev;
        rear.prev.next = newNode;
        rear.prev = newNode;
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
        TNode currNode = front.next;
        while (currNode.item != null) {
            System.out.print(currNode.item);
            System.out.print(" ");
            currNode = currNode.next;
        }
        System.out.println();
    }

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

    private T getRecursive(TNode t, int index) {
        if (index == 0) {
            return t.item;
        }
        return getRecursive(t.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursive(front.next, index);
    }

}
