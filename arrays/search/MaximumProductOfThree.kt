package leetcode.arrays.search

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */

private class MaximumProductOfThree {
    fun maximumProduct(nums: IntArray): Int {
        if (nums.size < 3) return 0

        val sortedNums = nums.sorted()

        return maxOf(
            sortedNums[0] * sortedNums[1] * sortedNums.last(),
            sortedNums.takeLast(3).reduce { acc, v -> acc * v })
    }
}
