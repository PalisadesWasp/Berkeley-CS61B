import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the LinkedListDeque class */
public class TestLinkedListDeque {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<String> lld = new LinkedListDeque<String>();
        assertEquals(0, lld.size());
        assertTrue(lld.isEmpty());

        lld.addFirst("1");
        assertEquals(1, lld.size());
        assertFalse(lld.isEmpty());

        lld.addLast("2");
        lld.addLast("3");
        assertEquals(3, lld.size());
        assertFalse(lld.isEmpty());

        String s = lld.get(1);
        assertEquals("1", lld.get(0));
        assertEquals("1", lld.getRecursive(0));
        assertEquals("2", lld.get(1));
        assertEquals("2", lld.getRecursive(1));
        assertNull(lld.get(3));
        assertNull(lld.getRecursive(3));

        lld.addLast("4");
        assertEquals("1", lld.removeFirst());
        lld.printDeque();

        lld.addFirst("0");
        assertEquals("4", lld.removeLast());
        lld.printDeque();
        assertEquals("2", lld.get(1));
        assertEquals("2", lld.getRecursive(1));
    }
}
