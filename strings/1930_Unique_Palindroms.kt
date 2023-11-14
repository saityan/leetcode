package leetcode.strings

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 *
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 */

private class `1930_Unique_Palindroms` {
    fun countPalindromicSubsequence(s: String): Int {
        var result = 0

        for (i in 'a'..'z') {
            val previous = s.indexOf(i)
            val next = s.lastIndexOf(i)

            if (previous != -1 && next != -1 && next > previous) {
                result += s.substring(previous + 1, next).toSet().size
            }
        }

        return result
    }
}
