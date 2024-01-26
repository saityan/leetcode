package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 */

private class RemoveTriplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var k = 1
        var count = 0

        for (i in 1..nums.lastIndex) {
            if (nums[i] == nums[i - 1]) {
                if (count == 0) {
                    count++
                    nums[k] = nums[i]
                    k++
                }
            } else {
                count = 0
                nums[k] = nums[i]
                k++
            }
        }

        return k
    }
}
