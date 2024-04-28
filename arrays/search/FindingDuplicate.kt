package leetcode.arrays.search

/**
 * https://leetcode.com/problems/contains-duplicate-ii
 *
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k
 */

private class FindingDuplicate {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            map[num]?.let {
                val distance = i - it
                if (distance <= k) {
                    return true
                }
            }
            map[num] = i
        }

        return false
    }
}
