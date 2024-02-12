package leetcode.arrays.path

private class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false
        if (nums.size == 1) return true

        var reach = 0
        for (i in nums.indices) {
            if (i > reach) return false
            reach = maxOf(reach, i + nums[i])
            if (reach >= nums.size - 1) return true
        }

        return true
    }
}
