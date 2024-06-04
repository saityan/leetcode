package leetcode.strings.calculation

// https://leetcode.com/problems/longest-palindrome

private class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val freqList = s.groupingBy { it }.eachCount().values.toList()
        var oddFound = false
        var result = 0

        for (freq in freqList) {
            if (freq % 2 != 0) {
                oddFound = true
                result += freq - 1
            } else {
                result += freq
            }
        }

        if (oddFound) {
            result++
        }

        return result
    }
}
