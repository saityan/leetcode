package leetcode.strings.search

/**
 * https://leetcode.com/problems/valid-anagram/
 */

private class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {

        if (s.isEmpty() || s.length != t.length)
            return false

        val dif = IntArray(26)
        for (i in s.indices) {
            dif[s[i] - 'a']++
            dif[t[i] - 'a']--
        }

        return dif.all { it == 0 }
    }
}
