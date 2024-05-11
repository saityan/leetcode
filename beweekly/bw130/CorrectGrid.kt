package leetcode.beweekly.bw130

// https://leetcode.com/contest/biweekly-contest-130/problems/check-if-grid-satisfies-conditions/

private class CorrectGrid {
    fun satisfiesConditions(grid: Array<IntArray>): Boolean {
        if (grid.isEmpty() || grid[0].isEmpty()) return false

        val rows = grid.size
        val cols = grid[0].size

        for (i in 0 until rows - 1) {
            for (j in 0 until cols) {
                if (grid[i][j] != grid[i + 1][j]) {
                    return false
                }
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols - 1) {
                if (grid[i][j] == grid[i][j + 1]) {
                    return false
                }
            }
        }

        return true
    }
}
