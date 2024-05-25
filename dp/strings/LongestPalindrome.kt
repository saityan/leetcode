package leetcode.dp.strings

// https://leetcode.com/problems/longest-palindromic-substring

private class LongestPalindrome {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        val n = s.length

        val dp = Array(n) { BooleanArray(n) }

        var start = 0
        var maxLength = 1

        for (i in 0 until n) {
            dp[i][i] = true
            if (i < n - 1 && s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                start = i
                maxLength = 2
            }
        }

        for (length in 3..n) {
            for (i in 0 until n - length + 1) {
                val j = i + length - 1

                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true

                    if (length > maxLength) {
                        start = i
                        maxLength = length
                    }
                }
            }
        }

        return s.substring(start, start + maxLength)
    }
}
