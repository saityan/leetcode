package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/longest-common-prefix
 */

private class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val result = StringBuilder()

        for (j in strs[0].indices) {
            val candidate = strs[0][j]

            for (i in strs.indices) {
                try {
                    if (strs[i][j] != candidate) {
                        return result.toString()
                    }
                } catch (e: Throwable) {
                    return result.toString()
                }
            }

            result.append(candidate)
        }

        return result.toString()
    }
}
