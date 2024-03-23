package leetcode.strings.search

/**
 * https://leetcode.com/problems/is-subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 */


private class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        if (t.isEmpty()) return false

        var pointer = -1

        for (letter in s) {
            pointer = t.indexOf(letter, pointer + 1)
            if (pointer == -1) {
                return false
            }
        }

        return true
    }
}
