/**
 * UC Berkeley CS 61B Spring 2018
 * https://sp18.datastructur.es/materials/proj/proj1b/proj1b
 * Project 1B: Applying and Testing Data Structures version 1.0
 * Use the deque from project 1A to examine if a given word is a palindrome
 */

public class Palindrome {
    /**
     * Return a Deque where the characters appear in the same order as in the String
     */
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> dq = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    /**
     * Helper method that recursively examines if the character stored in the front and back of a Deque are the same
     */
    private boolean isPalindrome(Deque<Character> dq) {
        if (dq.size() <= 1) {
            return true;
        }
        else {
            Character first = dq.removeFirst();
            Character last = dq.removeLast();
            return (first == last) && isPalindrome(dq);
        }
    }

    /**
     * Return true if the given word is a palindrome, and false otherwise
     */
    public boolean isPalindrome(String word) {
        Deque<Character> dq = wordToDeque(word);
        return isPalindrome(dq);
    }

    /**
     * Helper method that recursively examines if the character stored in the front and back of a Deque are the same,
     * according to the character comparison test provided by the CharacterComparator passed in
     */
    private boolean isPalindrome(Deque<Character> dq, CharacterComparator cc) {
        if (dq.size() <= 1) {
            return true;
        }
        else {
            Character first = dq.removeFirst();
            Character last = dq.removeLast();
            return (cc.equalChars(first, last)) && isPalindrome(dq, cc);
        }
    }

    /**
     * Return true if the given word is a palindrome, and false otherwise,
     * according to the character comparison test provided by the CharacterComparator passed in
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dq = wordToDeque(word);
        return isPalindrome(dq, cc);
    }
}
