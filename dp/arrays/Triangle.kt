package leetcode.dp.arrays

// https://leetcode.com/problems/triangle

private class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty() || triangle[0].isEmpty()) return 0

        val dp = triangle.last().toIntArray()

        for (i in triangle.size - 2 downTo 0) {
            for (j in 0 until triangle[i].size) {
                dp[j] = triangle[i][j] + minOf(dp[j], dp[j + 1])
            }
        }

        return dp[0]
    }
}
