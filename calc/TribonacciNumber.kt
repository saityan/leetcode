package leetcode.calc

/**
 * https://leetcode.com/problems/n-th-tribonacci-number
 *
 * Given n, return the value of Tn.
 */

private class TribonacciNumber {
    fun tribonacci(n: Int): Int {

        when {
            n < 0 || n > 37 -> return -1
            n == 0 -> return 0
            n == 1 || n == 2 -> return 1
        }

        val result = IntArray(n + 1)
        result[0] = 0
        result[1] = 1
        result[2] = 1

        for (i in 3 until n + 1) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3]
        }

        return result.last()
    }
}
