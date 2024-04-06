package leetcode.strings.transposal

import java.util.*

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * return any valid string
 */

private class ValidParentheses {
    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Int>()
        val toRemove = BooleanArray(s.length)

        for (i in s.indices) {
            when (s[i]) {
                '(' -> stack.push(i)
                ')' -> {
                    if (stack.isEmpty()) {
                        toRemove[i] = true
                    } else {
                        stack.pop()
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            toRemove[stack.pop()] = true
        }

        val result = StringBuilder()
        for (i in s.indices) {
            if (!toRemove[i]) {
                result.append(s[i])
            }
        }

        return result.toString()
    }
}
