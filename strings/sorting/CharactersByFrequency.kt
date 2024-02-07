package leetcode.strings.sorting

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */

private class CharactersByFrequency {
    fun frequencySort(s: String): String {
        if (s.isEmpty()) return ""

        val frequencyMap = HashMap<Char, Int>()
        for (letter in s) {
            frequencyMap[letter] = frequencyMap.getOrDefault(letter, 0) + 1
        }

        val sortedLetters = frequencyMap.entries.sortedByDescending { it.value }

        val result = StringBuilder()
        for ((char, count) in sortedLetters) {
            result.append(char.toString().repeat(count))
        }

        return result.toString()
    }
}
