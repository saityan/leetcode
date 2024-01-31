package leetcode.arrays.search

/**
 * https://leetcode.com/problems/daily-temperatures
 */

private class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.isEmpty()) return emptyArray<Int>().toIntArray()

        val n = temperatures.size
        val stack = mutableListOf<Int>()
        val result = IntArray(n)

        for (i in 0 until n) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val prevIndex = stack.removeAt(stack.lastIndex)
                result[prevIndex] = i - prevIndex
            }
            stack.add(i)
        }

        return result
    }
}
