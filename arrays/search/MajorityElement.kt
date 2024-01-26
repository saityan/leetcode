package leetcode.arrays.search

/**
 * https://leetcode.com/problems/majority-element
 */

private class MajorityElement {
    fun majorityElement(nums: IntArray): Int =
        nums.groupBy { it }.maxByOrNull { it.value.size }?.key ?: 0
}
