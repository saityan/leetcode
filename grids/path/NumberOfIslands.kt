package leetcode.grids.path

/**
 * https://leetcode.com/problems/number-of-islands
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 */

private class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        var result = 0
        val visited = Array(rows) { BooleanArray(cols) }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++
                    dfs(grid, visited, i, j)
                }
            }
        }

        return result
    }

    private fun dfs(grid: Array<CharArray>, visited: Array<BooleanArray>, row: Int, col: Int) {
        val rows = grid.size
        val cols = grid[0].size

        if (row !in 0 until rows || col !in 0 until cols || grid[row][col] == '0' || visited[row][col]) return

        visited[row][col] = true

        dfs(grid, visited, row + 1, col)
        dfs(grid, visited, row - 1, col)
        dfs(grid, visited, row, col + 1)
        dfs(grid, visited, row, col - 1)
    }
}
