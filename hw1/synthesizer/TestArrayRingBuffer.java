package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());
        //arb.dequeue();
        //arb.peek();

        arb.enqueue(1);
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(1, arb.fillCount());
        assertEquals((Integer) 1, arb.peek());

        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(5, arb.fillCount());
        assertEquals((Integer) 1, arb.peek());

        assertEquals((Integer) 1, arb.dequeue());
        assertEquals((Integer) 2, arb.dequeue());
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(3, arb.fillCount());
        assertEquals((Integer) 3, arb.peek());

        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        arb.enqueue(9);
        arb.enqueue(10);
        arb.enqueue(11);
        arb.enqueue(12);
        assertFalse(arb.isEmpty());
        assertTrue(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(10, arb.fillCount());
        assertEquals((Integer) 3, arb.peek());
        //arb.enqueue(13);

        assertEquals((Integer) 3, arb.dequeue());
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(10, arb.capacity());
        assertEquals(9, arb.fillCount());
        assertEquals((Integer) 4, arb.peek());
        for (Integer i : arb) {
            System.out.println(i); // 4 5 6 7 8 9 10 11 12
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
