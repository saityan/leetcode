package leetcode.dp

/**
 * https://leetcode.com/problems/fibonacci-number/
 */

class FibonacciNumber {
    fun fib(n: Int): Int {
        when {
            n < 0 -> return -1
            n == 0 -> return 0
            n == 1 -> return 1
        }

        var prev = 0
        var current = 1

        for (i in 2..n) {
            val next = prev + current
            prev = current
            current = next
        }

        return current
    }
}
