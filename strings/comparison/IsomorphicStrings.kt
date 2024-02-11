package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/isomorphic-strings
 */

private class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        return transformString(s) == transformString(t)
    }

    fun transformString(s: String): String {
        val map = HashMap<Char, Int>()
        var counter = 1
        val result = StringBuilder()

        for (char in s) {
            val index = map.getOrPut(char) { counter++ }
            result.append(index)
        }

        return result.toString()
    }
}
