package leetcode.arrays.search.binary

// https://leetcode.com/problems/search-insert-position

private class InsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0

        var start = 0
        var end = nums.lastIndex

        while (start <= end) {

            val center = start + (end - start) / 2

            when {
                nums[center] == target -> return center
                nums[center] < target -> start = center + 1
                else -> end = center - 1
            }
        }

        return start
    }
}
