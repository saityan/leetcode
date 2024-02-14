package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */

private class RearrangeBySign {
    fun rearrangeArray(nums: IntArray): IntArray {
        if (nums.isEmpty() || nums.size % 2 != 0)
            return intArrayOf()

        val positives = mutableListOf<Int>()
        val negatives = mutableListOf<Int>()

        for (num in nums) {
            when {
                num > 0 -> positives.add(num)
                num < 0 -> negatives.add(num)
                else -> throw Throwable("Not a valid array")
            }
        }

        if (positives.size != negatives.size) {
            throw Throwable("Not a valid array")
        }

        for ((j, i) in (0 until nums.lastIndex step 2).withIndex()) {
            nums[i] = positives[j]
            nums[i + 1] = negatives[j]
        }

        return nums
    }
}
