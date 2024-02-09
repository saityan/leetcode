package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/ransom-note
 */

private class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.isEmpty()) return true
        if (magazine.isEmpty()) return false

        val ransomMap = ransomNote.groupingBy { it }.eachCount()
        val magazineMap = magazine.groupingBy { it }.eachCount()

        val remainingCharacters = magazineMap.toMutableMap()
        ransomMap.forEach { (letter, count) ->
            remainingCharacters[letter] = remainingCharacters.getOrDefault(letter, 0) - count
        }

        return remainingCharacters.values.all { it >= 0 }
    }
}
