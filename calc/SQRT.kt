package leetcode.calc

/**
 * https://leetcode.com/problems/sqrtx
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 */

class SQRT {
    fun mySqrt(x: Int): Int {
        if (x == 0 || x == 1) return x

        var left = 1
        var right = x
        var result = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            val square = mid.toLong() * mid.toLong()

            if (square == x.toLong()) {
                return mid
            } else if (square < x) {
                left = mid + 1
                result = mid
            } else {
                right = mid - 1
            }
        }

        return result
    }
}
