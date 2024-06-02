package leetcode.strings.transposal

// https://leetcode.com/problems/reverse-string/

private class ReverseString {
    fun reverseString(s: CharArray): Unit {
        val size = s.size

        for (i in 0 until size / 2) {
            val temp = s[i]
            s[i] = s[size - 1 - i]
            s[size - 1 - i] = temp
        }
    }
}
