package leetcode.bits

/**
 * https://leetcode.com/problems/power-of-two/
 */

private class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean = n > 0 && n and (n - 1) == 0
}
