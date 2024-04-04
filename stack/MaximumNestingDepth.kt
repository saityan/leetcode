package leetcode.stack

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * Given a VPS represented as string s, return the nesting depth of s.
 */

private class MaximumNestingDepth {
    fun maxDepth(s: String): Int {
        if (s.isEmpty()) return 0

        var openCount = 0
        var closeCount = 0
        var result = 0

        for (letter in s) {
            when (letter) {
                '(' -> {
                    openCount++
                    result = max(result, openCount - closeCount)
                }
                ')' -> closeCount++
                else -> continue
            }
        }

        return result
    }
}
