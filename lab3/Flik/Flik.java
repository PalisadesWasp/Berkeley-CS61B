/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        /* For Integer objects, if the value is between -128 and 127, then == checks if the values are the same */
        return a == b; // i is 128

        /* When the value is > 127 or < -128, == checks if the variables refer to the same object reference (address) */
        //return a.equals(b); // uses a.equals(b) instead (i is 500)
    }
}
