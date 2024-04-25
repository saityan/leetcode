package leetcode.strings.transposal

/**
 * https://leetcode.com/problems/longest-ideal-subsequence
 *
 * Return the length of the longest ideal string.
 */

private class LongestIdealSubsequence {
    fun longestIdealString(s: String, k: Int): Int {
        val map = IntArray(26)
        var result = 0

        for (letter in s) {
            val index = letter - 'a'
            var currentMax = 0

            for (i in maxOf(0, index - k)..minOf(index + k, 25)) {
                currentMax = maxOf(currentMax, map[i])
            }

            map[index] = currentMax + 1
            result = maxOf(result, map[index])
        }

        return result
    }
}
