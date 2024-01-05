package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

private class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return 1

        val dp = IntArray(nums.size) { 1 }

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        return dp.maxOrNull() ?: -1
    }
}
