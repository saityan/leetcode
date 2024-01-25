package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */

private class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var k = 1

        for (i in 1..nums.lastIndex) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]
                k++
            }
        }

        return k
    }
}
