package leetcode.beweekly.bw125

/**
 * https://leetcode.com/contest/biweekly-contest-125/problems/minimum-operations-to-exceed-threshold-value-i/
 */

private class ExceedThresholdFirst {
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.count { it < k }
    }
}
