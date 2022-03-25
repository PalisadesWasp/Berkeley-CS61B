public class OffByN implements CharacterComparator {
    private int offset; // offset input for character comparison

    /**
     * Returns an object whose equalChars method returns true for characters that are off by the input value
     */
    public OffByN(int N) {
        offset = N;
    }

    /**
     * Returns true for characters that are different by the offset, false otherwise
     */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == offset) {
            return true;
        }
        return false;
    }
}
