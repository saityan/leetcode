package leetcode.grids

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland/
 *
 * Return a 2D array containing the 4-length arrays for each group of farmland in land.
 */

private class FindFarmland {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        if (land.isEmpty() || land[0].isEmpty()) return emptyArray()

        val result = mutableListOf<IntArray>()
        val visited = Array(land.size) {
            BooleanArray(land[0].size)
        }

        for (i in land.indices) {
            for (j in land[i].indices) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    val farmland = intArrayOf(i, j, i, j)
                    dfs(land, visited, i, j, farmland)
                    result.add(farmland)
                }
            }
        }

        return result.toTypedArray()
    }

    private fun dfs(
        land: Array<IntArray>,
        visited: Array<BooleanArray>,
        row: Int,
        col: Int,
        farmland: IntArray)
    {
        val rows = land.size
        val cols = land[0].size

        if (row !in 0 until rows || col !in 0 until cols || land[row][col] != 1 || visited[row][col]) return

        farmland[2] = maxOf(farmland[2], row)
        farmland[3] = maxOf(farmland[3], col)

        visited[row][col] = true

        dfs(land, visited, row + 1, col, farmland)
        dfs(land, visited, row, col + 1, farmland)
    }
}
