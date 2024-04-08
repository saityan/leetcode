package leetcode.arrays.calculation

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

private class ProductExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {

        if (nums.isEmpty()) return IntArray(0)

        val size = nums.size
        var leftSide = 1
        var rightSide = 1
        val result = IntArray(size) { 1 }

        for (i in nums.indices) {
            result[i] *= leftSide
            leftSide *= nums[i]
        }

        for (i in nums.indices.reversed()) {
            result[i] *= rightSide
            rightSide *= nums[i]
        }

        return result
    }
}
