import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<Integer>();
        String errMsg = "";

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            String msg = "";
            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                msg = "addLast(" + i + ")\n";
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                msg = "addFirst(" + i + ")\n";
            }
            errMsg += msg;
        }

        //System.out.println(errMsg);

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer actual = sad.removeFirst();
                Integer expected = ads.removeFirst();
                errMsg += "removeFirst()\n";
                assertEquals(errMsg, actual, expected);
                //System.out.println("removeFirst() actual: " + actual + " expected: " + expected);
            } else {
                Integer actual = sad.removeLast();
                Integer expected = ads.removeLast();
                errMsg += "removeLast()\n";
                assertEquals(errMsg, actual, expected);
                //System.out.println("removeLast() actual: " + actual + " expected: " + expected);
            }
        }
    }
}
