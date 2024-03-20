package leetcode.strings.search

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */

private class FirstOccurrence {
    fun strStr(haystack: String, needle: String): Int {
        val lastCommon = kmp(needle)
        var i = 0
        var j = 0

        while (i < haystack.length) {
            if (needle[j] == haystack[i]) {
                i++
                j++
            }
            if (j == needle.length) {
                return i - j
            } else if (i < haystack.length && needle[j] != haystack[i]) {
                if (j != 0) {
                    j = lastCommon[j - 1]
                } else {
                    i++
                }
            }
        }

        return -1
    }

    private fun kmp(needle: String): IntArray {
        val lastCommon = IntArray(needle.length)
        var previousCommon = 0
        var i = 1

        while (i < needle.length) {
            if (needle[i] == needle[previousCommon]) {
                previousCommon++
                lastCommon[i] = previousCommon
                i++
            } else {
                if (previousCommon != 0) {
                    previousCommon = lastCommon[previousCommon - 1]
                } else {
                    lastCommon[i] = previousCommon
                    i++
                }
            }
        }

        return lastCommon
    }
}
