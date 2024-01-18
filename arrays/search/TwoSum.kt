package leetcode.arrays.search

/**
 * https://leetcode.com/problems/two-sum/description/
 */

private class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size < 2) return emptyArray<Int>().toIntArray()

        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]

            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }

            map[nums[i]] = i
        }

        return emptyArray<Int>().toIntArray()
    }
}
