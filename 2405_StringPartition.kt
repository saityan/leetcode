package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/optimal-partition-of-string/
 *
 * Given a string s, partition the string into one or more substrings such that
 * the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 * Note that each character should belong to exactly one substring in a partition.
 */

private class `2405_StringPartition` {
    fun partitionString(s: String): Int {
        val current = Vector<Char>()
        var counter = 1
        for (i in s.indices) {
            if (current.contains(s[i])) {
                current.clear()
                current.add(s[i])
                counter++
                continue
            }
            current.add(s[i])
        }
        return counter
    }
}
