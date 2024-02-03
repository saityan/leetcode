package leetcode.dp

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum
 */

private class PartitionMaximumSum {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        if (arr.isEmpty() || k < 1) return 0

        val size = arr.size
        val dp = IntArray(size)

        for (i in 0 until size) {
            var localMax = Int.MIN_VALUE

            for (j in i downTo maxOf(0, i - k + 1)) {
                localMax = maxOf(localMax, arr[j])
                val prevMax = if (j > 0) dp[j - 1] else 0
                dp[i] = maxOf(dp[i], prevMax + localMax * (i - j + 1))
            }
        }

        return dp[size - 1]
    }
}
