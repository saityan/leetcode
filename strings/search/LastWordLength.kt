package leetcode.strings.search

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 */

private class LastWordLength {
    fun lengthOfLastWord(s: String): Int {
        if (s.isEmpty()) return 0

        var result = 0
        for(i in s.lastIndex downTo 0) {
            if(s[i] == ' ' && result > 0) {
                break
            } else if (s[i] == ' ') {
                continue
            }

            result++
        }

        return result
    }
}
