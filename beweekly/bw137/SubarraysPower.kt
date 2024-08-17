package leetcode.beweekly.bw137

// https://leetcode.com/contest/biweekly-contest-137/problems/find-the-power-of-k-size-subarrays-i/

private class SubarraysPower {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        if (k == 1) {
            return nums
        }

        val n = nums.size
        val result = IntArray(n - k + 1) { -1 }

        for (i in result.indices) {
            var isSequential = true

            for (j in i until i + k - 1) {
                if (nums[j + 1] != nums[j] + 1) {
                    isSequential = false
                    break
                }
            }

            if (isSequential) {
                result[i] = nums[i + k - 1]
            }
        }

        return result
    }
}
