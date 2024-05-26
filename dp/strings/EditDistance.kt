package leetcode.dp.strings

// https://leetcode.com/problems/edit-distance/

private class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val n = word1.length
        val m = word2.length

        if (n == 0 || m == 0) return maxOf(n, m)

        val dp = Array(n + 1) { IntArray(m + 1) }
        for (i in 0..n) {
            dp[i][0] = i
        }
        for (j in 0..m) {
            dp[0][j] = j
        }

        for (i in 1..n) {
            for (j in 1..m) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = minOf(dp[i][j - 1] + 1, minOf(dp[i -1][j] + 1), dp[i - 1][j - 1] + 1)
                }
            }
        }

        return dp.last().last()
    }
}
