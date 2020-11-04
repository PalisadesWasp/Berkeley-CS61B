import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedListDeque {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<String> LLD = new LinkedListDeque<String>();
        assertEquals(0, LLD.size());
        assertEquals(true, LLD.isEmpty());

        LLD.addFirst("1");
        assertEquals(1, LLD.size());
        assertEquals(false, LLD.isEmpty());

        LLD.addLast("2");
        LLD.addLast("3");
        assertEquals(3, LLD.size());
        assertEquals(false, LLD.isEmpty());

        String s = LLD.get(1);
        assertEquals("1", LLD.get(0));
        assertEquals("1", LLD.getRecursive(0));
        assertEquals("2", LLD.get(1));
        assertEquals("2", LLD.getRecursive(1));
        assertEquals(null, LLD.get(3));
        assertEquals(null, LLD.getRecursive(3));

        LLD.addLast("4");
        LLD.removeFirst();
        LLD.printDeque();

        LLD.addFirst("0");
        LLD.removeLast();
        LLD.printDeque();
        assertEquals("2", LLD.get(1));
        assertEquals("2", LLD.getRecursive(1));
    }
}
