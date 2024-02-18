package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/word-pattern
 */

private class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) return false

        val pMap = mutableMapOf<Char, String>()
        val sMap = mutableMapOf<String, Char>()

        for (i in pattern.indices) {
            val letter = pattern[i]
            val word = words[i]

            if (pMap.containsKey(letter)) {
                if (pMap[letter] != word) return false
            } else {
                if (sMap.containsKey(word)) return false
                pMap[letter] = word
                sMap[word] = letter
            }
        }

        return true
    }
}
