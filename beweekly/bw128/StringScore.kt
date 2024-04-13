package leetcode.beweekly.bw128

import kotlin.math.abs

/**
 * https://leetcode.com/contest/biweekly-contest-128/problems/score-of-a-string/
 *
 * You are given a string s. The score of a string is defined as the sum of the absolute difference between
 * the ASCII values of adjacent characters.
 */

private class StringScore {
    fun scoreOfString(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) {
            return s[0].code
        }

        var result = 0

        for (i in 0 until s.lastIndex) {
            result += abs(s[i].code - s[i + 1].code)
        }

        return result
    }
}
