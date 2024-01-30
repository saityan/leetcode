package leetcode.strings.calculation

import java.util.*

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 */

private class ReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        if (tokens.isEmpty() || tokens.size % 2 == 0) return 0
        if (tokens.size == 1) return tokens[0].toInt()

        val operands = Stack<Int>()

        for (token in tokens) {
            if (token in listOf("+", "*", "/", "-")) {
                val operandSecond = operands.pop()
                val operandFirst = operands.pop()

                when (token) {
                    "+" -> operands.push(operandFirst + operandSecond)
                    "*" -> operands.push(operandFirst * operandSecond)
                    "/" -> operands.push(operandFirst / operandSecond)
                    "-" -> operands.push(operandFirst - operandSecond)
                }
            } else {
                operands.push(token.toInt())
            }
        }

        return operands.pop()
    }
}
