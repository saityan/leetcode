package leetcode.arrays.matrix

/**
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
 */

private class DifferenceBetween {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        if (grid.isEmpty() || grid[0].isEmpty())
            return grid

        val result = Array(grid.size) { IntArray(grid[0].size) }

        val rowZeroSums = IntArray(grid.size)
        val colZeroSums = IntArray(grid[0].size)
        val rowOneSums = IntArray(grid.size)
        val colOneSums = IntArray(grid[0].size)

        for (i in grid.indices)
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    rowZeroSums[i]++
                    colZeroSums[j]++
                } else if (grid[i][j] == 1) {
                    rowOneSums[i]++
                    colOneSums[j]++
                }
            }

        for (i in grid.indices)
            for (j in grid[0].indices) {
                result[i][j] = rowOneSums[i] + colOneSums[j] - rowZeroSums[i] - colZeroSums[j]
            }

        return result
    }
}
