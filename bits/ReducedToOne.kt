package leetcode.bits

import java.math.BigInteger

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

private class ReducedToOne {
    fun numSteps(s: String): Int {
        val sb = StringBuilder(s)
        if (sb.any { it != '1' && it != '0' }) {
            return -1
        }

        var num = s.toBigInteger(2)
        var result = 0

        while (num > BigInteger.ONE) {
            if (num.and(BigInteger.ONE) == BigInteger.ZERO) {
                num = num.shiftRight(1)
            } else {
                num += BigInteger.ONE
            }

            result++
        }

        return result
    }
}
