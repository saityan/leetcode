package leetcode.strings.search

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

private class FirstUniqueCharacter {
    fun firstUniqChar(s: String): Int {
        if (s.isEmpty()) return -1

        val letters = IntArray(26)
        val firstOccurrence = IntArray(26) { -1 }

        for (i in s.indices) {
            val index = s[i].code - 'a'.code
            if (index !in 0..25) {
                throw Throwable("Invalid string")
            }

            letters[index]++
            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i
            }
        }

        var minIndex = Integer.MAX_VALUE
        for (i in letters.indices) {
            if (letters[i] == 1) {
                minIndex = minOf(minIndex, firstOccurrence[i])
            }
        }

        return if (minIndex == Int.MAX_VALUE) {
            -1
        } else minIndex
    }
}
