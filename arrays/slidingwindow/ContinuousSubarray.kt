package leetcode.arrays.slidingwindow

import java.util.*

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

private class ContinuousSubarray {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val minDeque = LinkedList<Int>()
        val maxDeque = LinkedList<Int>()
        var start = 0
        var result = 0

        for (end in nums.indices) {
            while (minDeque.isNotEmpty() && nums[minDeque.last] >= nums[end]) {
                minDeque.removeLast()
            }
            minDeque.addLast(end)

            while (maxDeque.isNotEmpty() && nums[maxDeque.last] <= nums[end]) {
                maxDeque.removeLast()
            }
            maxDeque.addLast(end)

            while (nums[maxDeque.first] - nums[minDeque.first] > limit) {
                start++
                if (minDeque.first < start) {
                    minDeque.removeFirst()
                }
                if (maxDeque.first < start) {
                    maxDeque.removeFirst()
                }
            }

            result = maxOf(result, end - start + 1)
        }

        return result
    }
}
