package leetcode.strings.calculation

/**
 * https://leetcode.com/problems/roman-to-integer
 */

private class RomanToInteger {
    fun romanToInt(s: String): Int {
        if (s.isEmpty()) return 0

        val map = linkedMapOf(
            Pair('I', 1),
            Pair('V', 5),
            Pair('X', 10),
            Pair('L', 50),
            Pair('C', 100),
            Pair('D', 500),
            Pair('M', 1000),
        )

        if (s.length == 1) return map[s[0]] ?: 0

        var result = 0
        var i = s.lastIndex
        while (i > 0) {
            map[s[i]]?.let { current ->
                map[s[i - 1]]?.let { previous ->
                    result += current
                    if (current > previous) {
                        result -= previous
                        i--
                    }
                    i--
                    if (i == 0) {
                        map[s[i]]?.let {
                            result += it
                        }
                    }
                }
            }
        }

        return result
    }
}
