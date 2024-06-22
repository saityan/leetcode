package leetcode.arrays.calculation

// https://leetcode.com/problems/count-number-of-nice-subarrays

private class NiceSubarrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val prefixCount = mutableMapOf<Int, Int>()
        prefixCount[0] = 1
        var prefixSum = 0
        var count = 0

        for (num in nums) {
            prefixSum += if (num % 2 == 0) 0 else 1

            count += prefixCount.getOrDefault(prefixSum - k, 0)

            prefixCount[prefixSum] = prefixCount.getOrDefault(prefixSum, 0) + 1
        }

        return count
    }
}
