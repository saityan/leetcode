package leetcode.arrays.search

/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */

private class ColorfulRope {

    fun minCost(colors: String, neededTime: IntArray): Int {
        if (colors.length <= 1) return 0

        var totalCost = 0
        var i = 0

        while (i < colors.lastIndex) {
            val currentColor = colors[i]
            var k = i

            while (k <= colors.lastIndex && colors[k] == currentColor) {
                k++
            }

            val segmentTimes = neededTime.copyOfRange(i, k)
            totalCost += segmentTimes.sum() - (segmentTimes.maxOrNull() ?: 0)

            i = k
        }

        return totalCost
    }
}
