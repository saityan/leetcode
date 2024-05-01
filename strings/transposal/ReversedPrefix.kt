package leetcode.strings.transposal

/**
 * https://leetcode.com/problems/reverse-prefix-of-word
 */

private class ReversedPrefix {
    fun reversePrefix(word: String, ch: Char): String {
        val sb = StringBuilder()
        var index = -1
        for (i in word.indices) {
            if (word[i] != ch) {
                sb.append(word[i])
            } else {
                sb.append(word[i])
                index = i
                break
            }
        }

        return if (index == -1) word else sb.reverse().append(word.substring(index + 1)).toString()
    }
}
