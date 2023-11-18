package leetcode.arrays

/**
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 *
 * The frequency of an element is the number of times it occurs in an array.
 * You are given an integer array nums and an integer k. In one operation,
 * you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 */

private class `1838_ Frequency` {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return 0

        val sortedNums = nums.copyOf().apply { sort() }

        var result = 1
        var left = 0
        var remainingSteps = k

        for (right in 1 until sortedNums.size) {
            remainingSteps -= (sortedNums[right] - sortedNums[right - 1]) * (right - left)

            while (remainingSteps < 0) {
                remainingSteps += sortedNums[right] - sortedNums[left]
                left++
            }

            result = maxOf(result, right - left + 1)
        }

        return result
    }
}
