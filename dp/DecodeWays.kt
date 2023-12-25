package leetcode.dp

/**
 * https://leetcode.com/problems/decode-ways/
 */

private class DecodeWays {
    fun numDecodings(s: String): Int {

        val sampleSize = s.length
        if (sampleSize == 0) return 0

        val dp = IntArray(sampleSize + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '0') 0 else 1

        for (i in 2..sampleSize) {
            if (s[i - 1] != '0') {
                val oneDigit = s.substring(i - 1, i).toInt()
                if (isValidLetter(oneDigit)) {
                    dp[i] += dp[i - 1]
                }
            }

            if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] in '0'..'9')) {
                val twoDigits = s.substring(i - 2, i).toInt()
                if (isValidLetter(twoDigits)) {
                    dp[i] += dp[i - 2]
                }
            }
        }

        return dp[sampleSize]
    }

    private fun isValidLetter(n: Int): Boolean = n in 1..26
}
