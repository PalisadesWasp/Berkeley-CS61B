/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/proj/proj1gold/proj1gold
 * Project 1 Gold: Autograding
 * A rudimentary autograder for project 1A
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    /**
     * Test the addFirst, addLast, removeFirst, and removeLast methods of StudentArrayDeque
     *
     * If adding 5 to the front, then 3 to the front, and removing from the front yields an
     * incorrect value, then the String message passed to assertEquals would be the following:
     *   addFirst(5)
     *   addFirst(3)
     *   removeFirst()
     */
    @Test
    public void testStudentArrayDeque() {
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

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer actual = sad.removeFirst();
                Integer expected = ads.removeFirst();
                errMsg += "removeFirst()\n";
                assertEquals(errMsg, actual, expected);
            } else {
                Integer actual = sad.removeLast();
                Integer expected = ads.removeLast();
                errMsg += "removeLast()\n";
                assertEquals(errMsg, actual, expected);
            }
        }
    }
}
