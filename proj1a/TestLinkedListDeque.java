import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedListDeque {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertEquals(0, lld1.size());
        assertEquals(true, lld1.isEmpty());

        lld1.addFirst("1");
        assertEquals(1, lld1.size());
        assertEquals(false, lld1.isEmpty());

        lld1.addLast("2");
        lld1.addLast("3");
        assertEquals(3, lld1.size());
        assertEquals(false, lld1.isEmpty());

        String s = lld1.get(1);
        assertEquals("1", lld1.get(0));
        assertEquals("1", lld1.getRecursive(0));
        assertEquals("2", lld1.get(1));
        assertEquals("2", lld1.getRecursive(1));
        assertEquals(null, lld1.get(3));
        assertEquals(null, lld1.getRecursive(3));

        lld1.addLast("4");
        lld1.removeFirst();
        lld1.printDeque();

        lld1.addFirst("0");
        lld1.removeLast();
        lld1.printDeque();
        assertEquals("2", lld1.get(1));
        assertEquals("2", lld1.getRecursive(1));
    }
}
