package leetcode.dp.grids

// https://leetcode.com/problems/unique-paths-i

private class UniquePaths {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) return -1
        val n = obstacleGrid.size
        val m = obstacleGrid[0].size

        val dp = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            if (obstacleGrid[i][0] == 1) break
            dp[i][0] = 1
        }

        for (j in 0 until m) {
            if (obstacleGrid[0][j] == 1) break
            dp[0][j] = 1
        }

        for (i in 1 until n) {
            for (j in 1 until m) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }

        return dp.last().last()
    }
}
