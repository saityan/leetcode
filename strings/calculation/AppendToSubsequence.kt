package leetcode.strings.calculation

// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence

private class AppendToSubsequence {
    fun appendCharacters(s: String, t: String): Int {
        val goal = t.length
        var achieved = 0
        var indexS = 0
        var indexT = 0

        while (indexS < s.length && indexT < goal && achieved < goal) {
            if (s[indexS] == t[indexT]) {
                indexS++
                indexT++
                achieved++
            } else {
                indexS++
            }
        }

        return goal - achieved
    }
}
