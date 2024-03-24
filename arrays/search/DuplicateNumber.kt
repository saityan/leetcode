package leetcode.arrays.search

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 *
 * There is only one repeated number in nums, return this repeated number.
 */

private class DuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        if (nums.isEmpty()) return -1

        var slug = nums[0]
        var hare = nums[0]

        do {
            slug = nums[slug]
            hare = nums[nums[hare]]
        } while (slug != hare)

        slug = nums[0]
        while (slug != hare) {
            slug = nums[slug]
            hare = nums[hare]
        }

        return hare
    }
}
