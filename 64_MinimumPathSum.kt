package leetcode

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * You can only move either down or right at any point in time.
 */

private class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {

        if (grid.isEmpty() || grid[0].isEmpty())
            return -1

        val height = grid.size
        val width = grid[0].size
        val map = Array(height) {
            IntArray(width)
        }

        for (m in 0 until height)
            for (n in 0 until width) {
                map[m][n] = grid[m][n]
                map[m][n] +=
                    when {
                        m == 0 && n == 0 -> 0
                        m == 0 && n != 0 -> map[m][n - 1]
                        n == 0 -> map[m - 1][n]
                        else -> minOf(map[m - 1][n], map[m][n - 1])
                    }
            }
        return map[height - 1][width - 1]
    }
}
