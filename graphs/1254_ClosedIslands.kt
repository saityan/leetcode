package leetcode.graphs

import java.util.LinkedList

/**
 * https://leetcode.com/problems/number-of-closed-islands/description/
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is
 * an island totally (all left, top, right, bottom) surrounded by 1s.

 * Return the number of closed islands.
 */

private class `1254_ClosedIslands` {
    fun closedIsland(grid: Array<IntArray>): Int {

        if (grid.isEmpty())
            return -1

        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }

        var result = 0
        for (i in grid.indices)
            for (j in grid[0].indices)
                if (
                    grid[i][j] == 0 &&
                    !visited[i][j] &&
                    bfs(i, j, grid.size, grid[0].size, grid, visited)
                )
                    result++
        return result
    }

    private fun bfs(x: Int, y: Int, m: Int, n: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Boolean {
        val queue = LinkedList<IntArray>()
        queue.offer(intArrayOf(x, y))
        visited[x][y] = true

        var isClosed = true
        val xDir = intArrayOf(0, 1, 0, -1)
        val yDir = intArrayOf(-1, 0, 1, 0)

        while (!queue.isEmpty()) {
            val temp = queue.poll()
            val xCurrent = temp[0]
            val yCurrent = temp[1]

            for (i in 0..3) {
                val r = xCurrent + xDir[i]
                val c = yCurrent + yDir[i]
                if (r < 0 || r >= m || c < 0 || c >= n)
                    isClosed = false
                else if (grid[r][c] == 0 && !visited[r][c]) {
                    queue.offer(intArrayOf(r, c))
                    visited[r][c] = true
                }
            }
        }
        return isClosed
    }
}
