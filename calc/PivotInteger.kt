package leetcode.calc

/**
 * https://leetcode.com/problems/find-the-pivot-integer/
 */

import kotlin.math.sqrt

private class PivotInteger {
    fun pivotInteger(n: Int): Int = (sqrt(2 * n * (n + 1).toDouble()) * 0.5).let {
        if (it.isFinite() && it % 1 == 0.0) it.toInt()
        else -1
    }
}
