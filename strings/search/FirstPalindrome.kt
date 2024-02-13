package leetcode.strings.search

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 */

private class FirstPalindrome {
    fun firstPalindrome(words: Array<String>): String {
        if (words.isEmpty()) return ""

        for (word in words) {
            val size = word.length
            if (size == 1) {
                return word
            }

            var isPalindrome = true
            for (i in 0 until size / 2) {
                if (word[i] != word[size - 1 - i]) {
                    isPalindrome = false
                    break
                }
            }
            if (isPalindrome) {
                return word
            }
        }

        return ""
    }
}
