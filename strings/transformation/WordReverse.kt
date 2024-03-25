package leetcode.strings.transformation

/**
 * https://leetcode.com/problems/reverse-words-in-a-string
 *
 * Given an input string s, reverse the order of the words.
 */

private class WordReverse {
    fun reverseWords(s: String): String {
        return s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
    }
}
