import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayDeque class */
public class TestArrayDeque {
    /** Test the ArrayDeque.AddFirst method */
    @Test
    public void testAddFirst() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        assertEquals(0, ad.size());
        assertTrue(ad.isEmpty());

        ad.addFirst("F1");
        ad.addFirst("F2");
        ad.addFirst("F3");
        ad.addFirst("F4");
        ad.addFirst("F5");
        ad.addFirst("F6");
        ad.addFirst("F7");
        ad.addFirst("F8");
        assertEquals(8, ad.size());
        assertFalse(ad.isEmpty());
        System.out.print("testAddFirst: ");
        ad.printDeque();
    }

    /** Test the ArrayDeque.AddLast method */
    @Test
    public void testAddLast() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        assertEquals(0, ad.size());
        assertTrue(ad.isEmpty());

        ad.addLast("R1");
        ad.addLast("R2");
        ad.addLast("R3");
        ad.addLast("R4");
        ad.addLast("R5");
        ad.addLast("R6");
        ad.addLast("R7");
        ad.addLast("R8");
        assertEquals(8, ad.size());
        assertFalse(ad.isEmpty());
        System.out.print("testAddLast: ");
        ad.printDeque();
    }

    /** Test the ArrayDeque.Add method */
    @Test
    public void testAdd() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        assertEquals(0, ad.size());
        assertTrue(ad.isEmpty());

        ad.addFirst("F1");
        assertEquals(1, ad.size());
        assertFalse(ad.isEmpty());

        ad.addFirst("F2");
        ad.addLast("R3");
        ad.addLast("R4");
        ad.addFirst("F5");
        ad.addLast("R6");
        ad.addLast("R7");
        ad.addFirst("F8");
        assertEquals(8, ad.size());
        assertFalse(ad.isEmpty());
        System.out.print("testAdd: ");
        ad.printDeque();
    }

    /** Test the ArrayDeque.RemoveFirst method */
    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("F1");
        ad.addFirst("F2");
        ad.addFirst("F3");
        ad.addFirst("F4");
        assertEquals("F4", ad.removeFirst());
        System.out.print("testRemoveFirst: ");
        ad.printDeque();

        assertEquals("F3", ad.removeFirst());
        assertEquals("F2", ad.removeFirst());
        assertEquals("F1", ad.removeFirst());
        assertNull(ad.removeFirst());
        System.out.print("testRemoveFirst: ");
        ad.printDeque();
        assertEquals(0, ad.size());
    }

    /** Test the ArrayDeque.RemoveLast method */
    @Test
    public void testRemoveLast() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("F1");
        ad.addFirst("F2");
        ad.addFirst("F3");
        ad.addFirst("F4");
        assertEquals("F1", ad.removeLast());
        System.out.print("testRemoveLast: ");
        ad.printDeque();

        assertEquals("F2", ad.removeLast());
        assertEquals("F3", ad.removeLast());
        assertEquals("F4", ad.removeLast());
        assertNull(ad.removeLast());
        System.out.print("testRemoveLast: ");
        ad.printDeque();
        assertEquals(0, ad.size());
    }

    /** Test the ArrayDeque.Get method */
    @Test
    public void testGet() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("F1");
        ad.addFirst("F2");
        ad.addFirst("F3");
        ad.addFirst("F4");
        ad.addFirst("F5");
        ad.addFirst("F6");
        assertEquals("F6", ad.get(0));
        assertEquals("F5", ad.get(1));
        assertEquals("F2", ad.get(4));
        assertEquals("F1", ad.get(5));
        assertNull(ad.get(6));
        assertNull(ad.get(-1));
        System.out.print("testGet: ");
        ad.printDeque();
    }

    /** Test the ArrayDeque.Resize method */
    @Test
    public void testResize() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        assertEquals(0, ad.size());
        assertTrue(ad.isEmpty());

        ad.addFirst("F1");
        ad.addLast("R2");
        ad.addFirst("F3");
        ad.addLast("R4");
        ad.addLast("R5");
        ad.addFirst("F6");
        ad.addFirst("F7");
        ad.addFirst("F8");
        ad.addLast("R9");
        ad.addFirst("F10");
        assertEquals(10, ad.size());
        System.out.print("testResize: ");
        ad.printDeque();
        ad.printStatus();

        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.printDeque();
        ad.printStatus();

        ad.removeLast();
        ad.printDeque();
        ad.printStatus();
    }

    /** Test the ArrayDeque.Get method (copied from Gradescope) */
    @Test
    public void testGetGS() {
        ArrayDeque ad = new ArrayDeque();
        ad.addFirst(0);
        assertEquals(0, ad.get(0));
        ad.addLast(2);
        ad.removeLast();
        assertEquals(0, ad.get(0));
        ad.addFirst(5);
        ad.addLast(6);
        ad.addLast(7);
        ad.removeFirst();
        ad.removeFirst();
        ad.addFirst(10);
        ad.addFirst(11);
        ad.addLast(12);
        ad.removeFirst();
        ad.removeLast();
        assertEquals(6, ad.get(1));
    }
}
