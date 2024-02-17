package leetcode.beweekly.bw124

/**
 * Given an array of integers called nums, you can perform the following operation while nums contains at least 2 elements:

Choose the first two elements of nums and delete them.
The score of the operation is the sum of the deleted elements.

Your task is to find the maximum number of operations that can be performed, such that all operations have the same score.

Return the maximum number of operations possible that satisfy the condition mentioned above.
 */

private class SameScore {
    fun maxOperations(nums: IntArray): Int {
        if (nums.size < 2) return 0

        val score = nums[0] + nums[1]
        var result = 1

        for (i in 2 until nums.lastIndex step 2) {
            if (nums[i] + nums[i + 1] == score) {
                result++
            } else {
                break
            }
        }

        return result
    }
}
