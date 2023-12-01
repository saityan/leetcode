package leetcode.strings.comparison;

/**
 * leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
 */

class IsEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (String s : word1)
                first.append(s);

        for (String s : word2)
                second.append(s);

        return first.toString().equals(second.toString());
    }
}
