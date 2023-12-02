package leetcode.strings.search;

import java.util.Arrays;

/**
 * leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */

class TotalFormedWords {
    public int countCharacters(String[] words, String chars) {

        if (chars.isEmpty())
            return 0;

        int result = 0;
        int[] frequency = new int[26];

        for (char c : chars.toCharArray()) {
            int index = c - 'a';
            frequency[index]++;
        }

        for (String s : words) {

            int[] count = Arrays.copyOf(frequency, 26);
            boolean contains = true;

            for (char letter : s.toCharArray()) {
                int index = letter - 'a';
                count[index]--;
                if (count[index] < 0) {
                    contains = false;
                    break;
                }
            }

            if (contains)
                result += s.length();
        }

        return result;
    }
}
