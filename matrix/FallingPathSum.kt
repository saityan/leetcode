package leetcode.matrix

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 */

private class FallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {

        val rows = matrix.size
        val cols = matrix[0].size

        if (matrix.isEmpty() || cols == 0) return 0
        if (cols == 1) return matrix.sumOf { it[0] }

        val memo = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }

        var res = Int.MAX_VALUE

        for (j in 0 until cols) {
            res = min(res, dfs(matrix, 0, j, rows, cols, memo))
        }

        return res
    }

    fun dfs(matrix: Array<IntArray>, row: Int, col: Int, rows: Int, cols: Int, memo: Array<IntArray>): Int {
        if (row == rows - 1) return matrix[row][col]

        if (memo[row][col] != Int.MAX_VALUE) return memo[row][col]

        val left = if (col > 0) dfs(matrix, row + 1, col - 1, rows, cols, memo) else Int.MAX_VALUE
        val middle = dfs(matrix, row + 1, col, rows, cols, memo)
        val right = if (col < cols - 1) dfs(matrix, row + 1, col + 1, rows, cols, memo) else Int.MAX_VALUE

        memo[row][col] = matrix[row][col] + min(left, min(middle, right))

        return memo[row][col]
    }
}
