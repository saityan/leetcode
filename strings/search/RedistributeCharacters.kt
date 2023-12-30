package leetcode.strings.search

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal
 */

private class RedistributeCharacters {
    fun makeEqual(words: Array<String>): Boolean {
        if (words.isEmpty()) return false
        if (words.size == 1) return true

        val lettersSum = IntArray(26)

        for (i in words.indices) {
            for (c in words[i]) {
                val index = c.code - 'a'.code
                if (index in 0..25) {
                    lettersSum[index]++
                }
            }
        }

        for (n in lettersSum) {
            if (n % words.size != 0)
                return false
        }

        return true
    }
}
