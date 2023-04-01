package leetcode

import kotlin.math.floor
import kotlin.math.log
import kotlin.math.roundToInt

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */

private class BinarySearch {
    fun search(nums: IntArray, target: Int): Int =
        when {
            nums.isEmpty() || nums.first() > target || nums.last() < target -> -1
            nums.size == 1 && nums[0] == target -> 0
            nums.size == 1 && nums[0] != target -> -1
            nums.first() == target -> 0
            nums.last() == target -> nums.size - 1
            else -> binarySearch(nums, target)
        }

    private fun binarySearch(array: IntArray, target: Int): Int {
        val size = array.size
        var left = 0
        var right = size - 1
        var index = -1
        while (left <= right) {
            val middle = (left + right) / 2
            if (array[middle] == target) {
                index = middle
                break
            } else if (array[middle] > target)
                right = middle - 1
            else
                left = middle + 1
        }
        return index
    }
}
