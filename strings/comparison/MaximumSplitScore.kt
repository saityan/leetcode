package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */

private class MaximumSplitScore {
    fun maxScore(s: String): Int {
        if (s.isEmpty()) return 0

        var maxScore = 0
        var zerosToLeft = 0
        var onesToRight = s.count { it == '1' }

        for (i in 0 until s.length - 1) {
            if (s[i] == '0') {
                zerosToLeft++
            } else {
                onesToRight--
            }

            val currentScore = zerosToLeft + onesToRight
            maxScore = maxOf(maxScore, currentScore)
        }

        return maxScore
    }
}
