package leetcode.arrays.search

private class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val map = nums.toHashSet()

        for (i in 0..nums.size) {
            if (!map.contains(i)) {
                return i
            }
        }

        return -1
    }
}
