package leetcode.arrays.path

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */

private class TrappingWater {
    fun trap(height: IntArray): Int {
        var result = 0
        val size = height.size
        val leftMax = IntArray(size)
        val rightMax = IntArray(size)

        leftMax[0] = height[0]
        for (i in 1 until size) {
            leftMax[i] = max(leftMax[i - 1], height[i])
        }

        rightMax[size - 1] = height[size - 1]
        for (i in size - 2 downTo 0) {
            rightMax[i] = max(rightMax[i + 1], height[i])
        }

        for (i in height.indices) {
            val localMin = min(leftMax[i], rightMax[i])
            if (localMin > height[i]) {
                result += localMin - height[i]
            }
        }

        return result
    }
}
