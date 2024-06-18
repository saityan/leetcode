package leetcode.arrays.comparison

// https://leetcode.com/problems/height-checker

private class HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        val expected = heights.sorted()
        var result = 0

        for (i in heights.indices) {
            if (expected[i] != heights[i]) result++
        }

        return result
    }
}
