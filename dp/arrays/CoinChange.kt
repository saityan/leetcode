package leetcode.dp.arrays

import kotlin.math.min

/**
 * https://leetcode.com/problems/coin-change
 *
 * Return the fewest number of coins that you need to make up the amount.
 */

private class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        if (amount < 0 || coins.isEmpty()) return -1

        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (target in 1..amount) {
            for (coin in coins) {
                if (coin <= target) {
                    dp[target] = min(dp[target], dp[target - coin] + 1)
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}
