package leetcode.arrays.calculation

private class SpecialArray {
    fun specialArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        for (k in 1..nums.size) {
            var count = 0
            for (n in nums) {
                if (n >= k) {
                    count++
                }
            }

            if (count == k) return count
        }

        return -1
    }
}
