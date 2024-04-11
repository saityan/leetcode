package leetcode.strings.transposal

import java.util.*

/**
 * https://leetcode.com/problems/remove-k-digits
 *
 * return the smallest possible integer after removing k digits from num
 */

private class RemovingKdigits {
    fun removeKdigits(num: String, k: Int): String {
        val stack = Stack<Char>()

        var removed = 0
        for (digit in num) {
            while (removed < k && stack.isNotEmpty() && digit < stack.peek()) {
                stack.pop()
                removed++
            }

            stack.push(digit)
        }

        while (removed < k) {
            stack.pop()
            removed++
        }

        val result = stack.joinToString("").trimStart('0')

        return result.ifEmpty { "0" }
    }
}
