package leetcode.dp

/**
 * https://leetcode.com/problems/word-break
 */

private class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toHashSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        for (i in 1..s.length) {
            for (j in 0 until i) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[s.length]
    }
}
