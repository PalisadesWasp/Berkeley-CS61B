import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the OffByN class */
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));

        assertFalse(offByN.equalChars('f', 'h'));
    }
}
