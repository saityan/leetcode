package leetcode.grids.path

/**
 * https://leetcode.com/problems/island-perimeter/
 *
 *
 */

private class IslandPerimeter {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var result = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 1) {
                    result += 4

                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 1
                    }

                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        result -= 1
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 1
                    }

                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        result -= 1
                    }
                }
            }
        }

        return result
    }
}
