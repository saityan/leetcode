package leetcode.arrays.optimization

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
 */

private class MakeEmpty {
    fun minOperations(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val map = nums.asIterable().groupingBy { it }.eachCount()

        var res = 0

        for (entry in map) {
            val count = entry.value

            val triplets = count / 3
            res += triplets

            val remainingCount = count % 3

            when (remainingCount) {
                1 -> {
                    if (triplets == 0) {
                        return -1
                    } else {
                        res += 1
                    }
                }
                2 -> {
                    res += 1
                }
            }
        }

        return res
    }
}
