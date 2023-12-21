package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */

private class WidestAreaBetween {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        if (points.isEmpty() || points[0].isEmpty()) return -1

        val valuesX = points.map { it[0] }.toIntArray().apply { sort() }

        return (0 until valuesX.lastIndex)
            .map { valuesX[it + 1] - valuesX[it] }
            .maxByOrNull { it } ?: 0
    }
}
