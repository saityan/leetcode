package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
 */

private class AreStringsAlike {
    fun halvesAreAlike(s: String): Boolean {

        if (s.isEmpty() || s.length % 2 != 0) {
            return false
        }

        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var vowelsFirst = 0
        var vowelsSecond = 0
        for (i in s.indices) {
            if (s[i] in vowels) {
                if (i < s.length / 2) {
                    vowelsFirst++
                } else {
                    vowelsSecond++
                }
            }
        }

        return vowelsFirst == vowelsSecond
    }
}
