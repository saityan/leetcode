package leetcode.dp

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
 */


private class DiceRollsWithTarget {
    val modulo = 1000000007L

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int =
        when {
            target < n || target > n * k -> 0
            target == n || target == n * k -> 1
            else -> calculateWays(n = n, k = k, target = target)
        }

    private fun calculateWays(n: Int, k: Int, target: Int): Int {
        val dp = Array(n + 1) { Array(target + 1) { 0L } }

        for (j in 1..k.coerceAtMost(target)) {
            dp[1][j] = 1
        }

        for (i in 2..n) {
            for (j in 1..target) {
                for (x in 1..k.coerceAtMost(j - 1)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % modulo
                }
            }
        }

        return dp[n][target].toInt()
    }
}
