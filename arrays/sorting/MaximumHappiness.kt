package leetcode.arrays.sorting

// https://leetcode.com/problems/maximize-happiness-of-selected-children

private class MaximumHappiness {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        if (happiness.isEmpty() || k < 0) return 0

        val sortedHappiness = happiness.sortedArrayDescending()
        var result = 0L

        for (i in sortedHappiness.indices) {
            if (sortedHappiness[i] - i < 1 || k - i < 1) {
                return result
            } else {
                result += sortedHappiness[i] - i
            }
        }

        return result
    }
}
