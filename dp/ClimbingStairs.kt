package leetcode.dp

/**
 * https://leetcode.com/problems/climbing-stairs/
 */

private class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        if (n < 1) return 0
        if (n == 1) return 1

        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2

        for (i in 2..dp.lastIndex) {
            dp[i] = dp[i - 2] + dp[i - 1]
        }

        return dp.last()
    }
}
