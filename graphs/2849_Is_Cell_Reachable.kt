package leetcode.graphs

import kotlin.math.abs
import kotlin.math.max

/**
 *  https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
 *
 *  Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
 */

private class `2849_Is_Cell_Reachable` {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean =
        !((fx == sx && fy == sy && t == 1) || t < max(abs(fx - sx), abs(fy - sy)))
}
