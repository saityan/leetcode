package leetcode.strings.calculation

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */

private class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0

        val size = s.length
        var count = 0
        val dp = Array(size) { BooleanArray(size) }

        for (i in 0 until size) {
            dp[i][i] = true
            count++
        }

        for (i in 0 until size - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                count++
            }
        }

        for (length in 3..size) {
            for (start in 0 until size - length + 1) {
                val end = start + length - 1
                if (s[start] == s[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true
                    count++
                }
            }
        }

        return count
    }
}
