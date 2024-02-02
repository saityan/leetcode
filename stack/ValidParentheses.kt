package leetcode.stack

import java.util.Stack

/**
 * https://leetcode.com/problems/valid-parentheses/
 */

private class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val stack = Stack<Char>()

        for (symbol in s) {
            when (symbol) {
                '[', '(', '{' -> stack.push(symbol)
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            }
        }

        return stack.isEmpty()
    }
}
