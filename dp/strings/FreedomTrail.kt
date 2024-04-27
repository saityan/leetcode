package leetcode.dp.strings

import kotlin.math.abs

/**
 * https://leetcode.com/problems/freedom-trail/
 *
 * return the minimum number of steps to spell all the characters in the keyword
 */

private class FreedomTrail {
    fun findRotateSteps(ring: String, key: String): Int {
        val ringSize = ring.length
        val keySize = key.length
        val dp = Array(keySize + 1) { IntArray(ringSize) }

        for (i in keySize - 1 downTo 0) {
            for (j in 0 until ringSize) {
                dp[i][j] = Int.MAX_VALUE
                for (k in 0 until ringSize) {
                    if (ring[k] == key[i]) {
                        val diff = abs(j - k)
                        val steps = minOf(diff, ringSize - diff) + 1
                        dp[i][j] = minOf(dp[i][j], steps + dp[i + 1][k])
                    }
                }
            }
        }

        return dp[0][0]
    }
}
