package leetcode.grids

// https://leetcode.com/problems/largest-local-values-in-a-matrix

private class LargestLocal {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        if (grid.isEmpty() || grid.size < 3 || grid.size != grid[0].size) return emptyArray()

        val size = grid.size
        val result = Array(size - 2) {
            IntArray(size - 2) {
                Int.MIN_VALUE
            }
        }

        for (i in 0 until size - 2) {
            for (j in 0 until size - 2) {
                for (row in i until i + 3) {
                    for (col in j until j + 3) {
                        result[i][j] = maxOf(grid[row][col], result[i][j])
                    }
                }
            }
        }

        return result
    }
}
