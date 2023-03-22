package leetcode

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * Given an integer array nums, return the number of subarrays filled with 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.Given an integer array nums, return the number of subarrays filled with 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

private fun zeroFilledSubarray(nums: IntArray): Long {
    var subs = 0L
    for (n in nums.indices) {
        if (n > 0 && nums[n - 1] == 0)
            continue
        if (nums[n] == 0) {
            var k = n
            while (k < nums.size && nums[k] == 0)
                k++
            subs += (k - n).toLong() * (k - n + 1).toLong() / 2
        }
    }
    return subs
}
