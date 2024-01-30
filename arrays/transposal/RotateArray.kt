package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/rotate-array
 */

private class RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty() || k < 0) return

        val size = nums.size
        val rotation = k % size
        if (rotation == 0) return

        val oldNums = nums.clone()

        for (i in nums.indices) {
            if (i + rotation < size) {
                nums[i + rotation] = oldNums[i]
            } else {
                nums[i + rotation - size] = oldNums[i]
            }
        }
    }
}
