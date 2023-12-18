package leetcode.arrays.search

/**
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */

private class MaximumProductDifference {
    fun maxProductDifference(nums: IntArray): Int {
        if (nums.size < 4)
            return 0

        var minFirst = Integer.MAX_VALUE
        var minSecond = Integer.MAX_VALUE
        var maxFirst = Integer.MIN_VALUE
        var maxSecond = Integer.MIN_VALUE

        for (n in nums) {

            if (n < minFirst) {
                minSecond = minFirst
                minFirst = n
            } else if (n < minSecond)
                minSecond = n

            if (n > maxFirst) {
                maxSecond = maxFirst
                maxFirst = n
            }
            else if (n > maxSecond)
                maxSecond = n
        }

        return maxFirst * maxSecond - minFirst * minSecond
    }
}
