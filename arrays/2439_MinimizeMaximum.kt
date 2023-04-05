package leetcode.arrays

import kotlin.math.ceil
import kotlin.math.max

/**
 * https://leetcode.com/problems/minimize-maximum-of-array/
 *
 * You are given a 0-indexed array nums comprising of n non-negative integers.
 * In one operation, you must:
 * Choose an integer i such that 1 <= i < n and nums[i] > 0.
 * Decrease nums[i] by 1.
 * Increase nums[i - 1] by 1.
 * Return the minimum possible value of the maximum integer of nums after performing any number of operations.
 *
 * Constraints:
 * n == nums.length
 * 2 <= n <= 105
 * 0 <= nums[i] <= 109
 */

class `2439_MinimizeMaximum` {
    fun minimizeArrayValue(nums: IntArray): Int {
        var result = 0
        var currentSum = 0.0
        for (i in nums.indices) {
            currentSum += nums[i]
            result = max(result, ceil(currentSum / (i + 1)).toInt())
        }
        return result
    }
}
