package leetcode.arrays.search

import kotlin.math.max

/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */

private class ColorfulRope {

    fun minCost(colors: String, neededTime: IntArray): Int {
        if (colors.length <= 1) return 0

        var res = 0
        var i = 0

        while (i < colors.lastIndex) {
            if (colors[i] != colors[i + 1]) {
                i++
                continue
            }

            var k = i
            var currentSum = 0
            var currentMax = 0

            while (k <= colors.lastIndex && colors[k] == colors[i]) {
                currentSum += neededTime[k]
                currentMax = max(currentMax, neededTime[k])
                k++
            }

            res += currentSum - currentMax

            i = k
        }

        return res
    }
}
