package leetcode.matrix

/**
 * https://leetcode.com/problems/maximal-rectanglehttps://leetcode.com/problems/maximal-rectangle
 *
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 */

private class MaximalRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        val rows = matrix.size
        val cols = matrix[0].size
        val heights = IntArray(cols)
        var maxArea = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1
                } else {
                    heights[j] = 0
                }
            }

            maxArea = maxOf(maxArea, largestRectangleArea(heights))
        }

        return maxArea
    }

    fun largestRectangleArea(heights: IntArray): Int {
        val stack = mutableListOf<Int>()
        var maxArea = 0
        var i = 0
        while (i < heights.size) {
            if (stack.isEmpty() || heights[i] >= heights[stack.last()]) {
                stack.add(i)
                i++
            } else {
                val top = stack.removeLast()
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                maxArea = maxOf(maxArea, heights[top] * width)
            }
        }
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            val width = if (stack.isEmpty()) heights.size else heights.size - stack.last() - 1
            maxArea = maxOf(maxArea, heights[top] * width)
        }
        return maxArea
    }
}
