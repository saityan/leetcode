package leetcode.arrays.sums

/**
 * https://leetcode.com/problems/count-elements-with-maximum-frequency
 */

private class MaximumFreakCount {
    fun maxFrequencyElements(nums: IntArray): Int {

        val frequencyMap = nums.groupBy { it }.mapValues { it.value.size }

        val maxCount = frequencyMap.values.maxOrNull() ?: 0

        val maxFreqCount = frequencyMap.values.count { it == maxCount }

        return maxCount * maxFreqCount
    }
}
