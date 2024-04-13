package leetcode.beweekly.bw128

/**
 * https://leetcode.com/contest/biweekly-contest-128/problems/minimum-rectangles-to-cover-points/
 *
 * Return an integer denoting the minimum number of rectangles needed so that
 * each point is covered by at least one rectangle.
 */

private class CoverRectangles {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        if (points.isEmpty() || points[0].isEmpty()) return -1

        val xSet = points.map { it[0] }.toSortedSet()

        if (w == 0) {
            return xSet.size
        }

        var result = 1
        var current = xSet.first()
        for (x in xSet) {
            if (x - current <= w) {
                continue
            } else {
                current = x
                result++
            }
        }

        return result
    }
}
