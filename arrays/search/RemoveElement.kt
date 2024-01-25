package leetcode.arrays.search

/**
 * https://leetcode.com/problems/remove-element
 */

private class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0

        var k = 0

        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }

        return k
    }
}
