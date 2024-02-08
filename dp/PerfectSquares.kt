package leetcode.dp

/**
 * https://leetcode.com/problems/perfect-squares/
 */

private class PerfectSquares {
    fun numSquares(n: Int): Int {
        if (n < 0) return -1
        if (n == 0) return 0

        val squares = mutableListOf<Int>()
        var k = 1
        while (k * k <= n) {
            squares.add(k * k)
            k++
        }

        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in 1..n) {
            for (square in squares) {
                if (i < square) break
                dp[i] = minOf(dp[i], dp[i - square] + 1)
            }
        }

        return dp[n]
    }
}
