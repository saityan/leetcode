package leetcode.arrays

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */

private class MaximumProductOfTwo {
    fun maxProduct(nums: IntArray): Int {
        var max = Integer.MIN_VALUE
        var secondMax = Integer.MIN_VALUE

        for (n in nums) {
            if (n > max) {
                secondMax = max
                max = n
            } else if (n > secondMax)
                secondMax = n
        }

        return (max - 1) * (secondMax - 1)
    }
}
