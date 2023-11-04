package leetcode.arrays

import kotlin.math.max

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 *
 * Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right,
 * return the moment when the last ant(s) fall out of the plank.
 */

private class `1503_Last_Moment` {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        return when {
            left.isEmpty() && right.isEmpty() -> 0
            right.isEmpty() -> left.maxOrNull() ?: 0
            left.isEmpty() -> n - (right.minOrNull() ?: 0)
            else -> max(n - (right.minOrNull() ?: 0), left.maxOrNull() ?: 0)
        }
    }
}
