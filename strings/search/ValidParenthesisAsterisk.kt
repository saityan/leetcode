package leetcode.strings.search

import java.util.*

/**
 * https://leetcode.com/problems/valid-parenthesis-string
 *
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 */

private class ValidParenthesisAsterisk {
    fun checkValidString(s: String): Boolean {
        val openStack = Stack<Int>()
        val asteriskStack = Stack<Int>()

        for (i in s.indices) {
            when (s[i]) {
                '(' -> openStack.push(i)
                ')' -> {
                    if (openStack.isNotEmpty()) {
                        openStack.pop()
                    } else if (asteriskStack.isNotEmpty()) {
                        asteriskStack.pop()
                    } else {
                        return false
                    }
                }
                '*' -> asteriskStack.push(i)
            }
        }

        while (openStack.isNotEmpty() && asteriskStack.isNotEmpty()) {
            if (openStack.peek() < asteriskStack.peek()) {
                openStack.pop()
                asteriskStack.pop()
            } else {
                break
            }
        }

        return openStack.isEmpty()
    }
}
