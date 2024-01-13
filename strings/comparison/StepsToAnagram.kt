package leetcode.strings.comparison

import kotlin.math.max

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */

private class StepsToAnagram {
    fun minSteps(s: String, t: String): Int {
        if (s.length != t.length) return -1
        if (s.isEmpty()) return 0

        val mapSource = s.groupingBy { it }.eachCount()
        val mapTarget = t.groupingBy { it }.eachCount()

        var overflowFirst = 0
        var overflowSecond = 0

        for ((key, count) in mapSource) {
            overflowFirst += max(count - (mapTarget[key] ?: 0), 0)
        }

        for ((key, count) in mapTarget) {
            overflowSecond += max(count - (mapSource[key] ?: 0), 0)
        }

        return max(overflowFirst, overflowSecond)
    }
}
