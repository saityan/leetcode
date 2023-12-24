package leetcode.arrays.sorting

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */

private class AlternatingString {

    fun minOperations(s: String): Int {

        if (s.length < 2) return 0

        val goalFirst = StringBuilder(s.length)
        val goalSecond = StringBuilder(s.length)

        for (i in s.indices step 2) {
            goalFirst.append("10")
            goalSecond.append("01")
        }

        var resFirst = 0
        var resSecond = 0

        for ((i, char) in s.withIndex()) {
            if (char != goalFirst[i]) {
                resFirst++
            }
            if (char != goalSecond[i]) {
                resSecond++
            }
        }

        return min(resFirst, resSecond)
    }
}
