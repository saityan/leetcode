package codewars.strings

/**
 * https://leetcode.com/problems/sort-vowels-in-a-string/
 */

private class `2785_Sort_Vowels` {
    fun sortVowels(s: String): String {
        val vowels = ArrayList<Int>()
        val result = java.lang.StringBuilder()

        for (char in s) {
            if (char.lowercaseChar() in setOf('a', 'e', 'i', 'o', 'u')) {
                vowels.add(char.code)
            }
        }
        vowels.sort()

        var n = 0
        for (letter in s) {
            if (letter.lowercaseChar() in setOf('a', 'e', 'i', 'o', 'u')) {
                result.append(vowels[n].toChar())
                n++
            }
            else
                result.append(letter)
        }

        return result.toString()
    }
}
