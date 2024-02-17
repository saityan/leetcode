package leetcode.beweekly.bw124

/**
 * You are given a string s.

Consider performing the following operation until s becomes empty:

For every alphabet character from 'a' to 'z', remove the first occurrence of that character in s (if it exists).
Return the value of the string s right before applying the last operation.
 */

private class MakeStringEmpty {
    fun lastNonEmptyString(s: String): String {
        if (s.isEmpty()) return ""
        if (s.length == 1) return s

        val sequence = Array(26) { mutableListOf<Int>() }
        val result = StringBuilder()

        for (i in s.indices) {
            sequence[s[i].code - 'a'.code].add(i)
        }

        var maxSize = 0
        for (list in sequence) {
            maxSize = maxOf(maxSize, list.size)
        }

        val pairs = mutableListOf<Pair<Char, Int>>()
        for (i in sequence.indices) {
            if (sequence[i].size == maxSize) {
                pairs.add(Pair((i + 'a'.code).toChar(), sequence[i].last()))
            }
        }
        pairs.sortBy { it.second }
        for (pair in pairs) {
            result.append(pair.first)
        }

        return result.toString()
    }
}
