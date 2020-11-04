import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque {
    @Test
    public void testAddFirst() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        assertEquals(0, AD.size());
        assertEquals(true, AD.isEmpty());

        AD.addFirst("F1");
        AD.addFirst("F2");
        AD.addFirst("F3");
        AD.addFirst("F4");
        AD.addFirst("F5");
        AD.addFirst("F6");
        AD.addFirst("F7");
        AD.addFirst("F8");
        assertEquals(8, AD.size());
        assertEquals(false, AD.isEmpty());
        System.out.print("testAddFirst: ");
        AD.printDeque();
    }

    @Test
    public void testAddLast() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        assertEquals(0, AD.size());
        assertEquals(true, AD.isEmpty());

        AD.addLast("R1");
        AD.addLast("R2");
        AD.addLast("R3");
        AD.addLast("R4");
        AD.addLast("R5");
        AD.addLast("R6");
        AD.addLast("R7");
        AD.addLast("R8");
        assertEquals(8, AD.size());
        assertEquals(false, AD.isEmpty());
        System.out.print("testAddLast: ");
        AD.printDeque();
    }

    @Test
    public void testAdd() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        assertEquals(0, AD.size());
        assertEquals(true, AD.isEmpty());

        AD.addFirst("F1");
        assertEquals(1, AD.size());
        assertEquals(false, AD.isEmpty());

        AD.addFirst("F2");
        AD.addLast("R3");
        AD.addLast("R4");
        AD.addFirst("F5");
        AD.addLast("R6");
        AD.addLast("R7");
        AD.addFirst("F8");
        assertEquals(8, AD.size());
        assertEquals(false, AD.isEmpty());
        System.out.print("testAdd: ");
        AD.printDeque();
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        AD.addFirst("F1");
        AD.addFirst("F2");
        AD.addFirst("F3");
        AD.addFirst("F4");
        assertEquals("F4", AD.removeFirst());
        System.out.print("testRemoveFirst: ");
        AD.printDeque();

        assertEquals("F3", AD.removeFirst());
        assertEquals("F2", AD.removeFirst());
        assertEquals("F1", AD.removeFirst());
        assertEquals(null, AD.removeFirst());
        System.out.print("testRemoveFirst: ");
        AD.printDeque();
        assertEquals(0, AD.size());
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        AD.addFirst("F1");
        AD.addFirst("F2");
        AD.addFirst("F3");
        AD.addFirst("F4");
        assertEquals("F1", AD.removeLast());
        System.out.print("testRemoveLast: ");
        AD.printDeque();

        assertEquals("F2", AD.removeLast());
        assertEquals("F3", AD.removeLast());
        assertEquals("F4", AD.removeLast());
        assertEquals(null, AD.removeLast());
        System.out.print("testRemoveLast: ");
        AD.printDeque();
        assertEquals(0, AD.size());
    }

    @Test
    public void testGet() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        AD.addFirst("F1");
        AD.addFirst("F2");
        AD.addFirst("F3");
        AD.addFirst("F4");
        AD.addFirst("F5");
        AD.addFirst("F6");
        assertEquals("F6", AD.get(0));
        assertEquals("F5", AD.get(1));
        assertEquals("F2", AD.get(4));
        assertEquals("F1", AD.get(5));
        assertEquals(null, AD.get(6));
        assertEquals(null, AD.get(-1));
        System.out.print("testGet: ");
        AD.printDeque();
    }

    @Test
    public void testResize() {
        ArrayDeque<String> AD = new ArrayDeque<String>();
        assertEquals(0, AD.size());
        assertEquals(true, AD.isEmpty());

        AD.addFirst("F1");
        AD.addLast("R2");
        AD.addFirst("F3");
        AD.addLast("R4");
        AD.addLast("R5");
        AD.addFirst("F6");
        AD.addFirst("F7");
        AD.addFirst("F8");
        AD.addLast("R9");
        AD.addFirst("F10");
        assertEquals(10, AD.size());
        System.out.print("testResize: ");
        AD.printDeque();
        AD.printStatus();

        AD.removeFirst();
        AD.removeFirst();
        AD.removeLast();
        AD.removeFirst();
        AD.removeLast();
        AD.printDeque();
        AD.printStatus();

        AD.removeLast();
        AD.printDeque();
        AD.printStatus();
    }
}
