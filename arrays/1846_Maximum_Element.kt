package leetcode.arrays

/**
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 *
 * Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.
 */

private class `1846_Maximum_Element` {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int =
        arr.apply {
            sort()
            forEachIndexed { index, value ->
                arr[index] = if (index == 0) 1 else minOf(value, arr[index - 1] + 1)
            }
        }.let {
            return@let arr.last()
        }
}
