package leetcode.arrays.search

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 *
 * Return the positive integer k. If there is no such integer, return -1.
 */

private class LargestWithNegative {
    fun findMaxK(nums: IntArray): Int {
        if (nums.size < 2) return -1
        val sortedNums = nums.sorted()
        var left = 0
        var right = sortedNums.size - 1

        while (left < right) {
            if (-sortedNums[left] == sortedNums[right]) {
                return sortedNums[right]
            } else if (-sortedNums[left] > sortedNums[right]) {
                left++
            } else {
                right--
            }
        }

        return -1
    }
}
