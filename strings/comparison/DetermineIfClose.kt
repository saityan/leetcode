package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 */

private class DetermineIfClose {
    fun closeStrings(word1: String, word2: String): Boolean {

        if (word1.length != word2.length) return false
        if (word1.isEmpty()) return true

        val freqFirst = word1.groupingBy { it }.eachCount()
        val freqSecond = word2.groupingBy { it }.eachCount()

        for (key in freqFirst.keys) {
            if (!freqSecond.containsKey(key)) {
                return false
            }
        }

        return freqFirst.values.toIntArray().sorted() == freqSecond.values.toIntArray().sorted()
    }
}
