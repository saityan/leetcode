package leetcode.strings.sorting

/**
 * https://leetcode.com/problems/custom-sort-string/
 */

private class CustomSort {
    fun customSortString(order: String, s: String): String {

        if (order.isEmpty() || s.isEmpty()) {
            return s
        }

        val result = StringBuilder()
        val lettersMap = IntArray(26)
        val base = 'a'.code

        for (letter in s) {
            val index = letter.code - base
            if (index !in 0..25) {
                throw IllegalArgumentException("the string should consist of lowercase English letters only")
            }

            lettersMap[index]++
        }

        for (symbol in order) {
            val index = symbol.code - base
            if (index !in 0..25) {
                throw IllegalArgumentException("the order should consist of lowercase English letters only")
            }

            result.append(symbol.toString().repeat(lettersMap[index]))
            lettersMap[index] = 0
        }

        for (i in 0 until 26) {
            val count = lettersMap[i]
            val letter = (i + base).toChar()
            result.append(letter.toString().repeat(count))
        }

        return result.toString()
    }
}
