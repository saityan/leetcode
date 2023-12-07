package leetcode.strings.search

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 */

private class LargestOdd {
    fun largestOddNumber(num: String): String {
        for (i in num.length - 1 downTo 0) {
            if (num[i].code % 2 == 1)
                return num.substring(0, i + 1)
        }
        return ""
    }
}
