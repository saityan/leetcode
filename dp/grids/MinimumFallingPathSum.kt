package leetcode.dp.grids

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii
 *
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 */

private class MinimumFallingPathSum {
    fun minFallingPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        val rows = grid.size
        val cols = grid[0].size
        val dp = Array(rows) { i ->
            if (i == 0) {
                IntArray(cols) { j -> grid[0][j] }
            } else {
                IntArray(cols) { Int.MAX_VALUE }
            }
        }

        for (i in 1 until rows) {
            for (j in 0 until cols) {
                for (k in 0 until cols) {
                    if (j == k) {
                        continue
                    } else {
                        dp[i][j] = min(dp[i - 1][k] + grid[i][j], dp[i][j])
                    }
                }
            }
        }

        return dp[rows - 1].minOrNull() ?: 0
    }
}
