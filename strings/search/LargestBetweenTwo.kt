package leetcode.strings.search

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */

private class LargestBetweenTwo {
    fun maxLengthBetweenEqualCharacters(s: String): Int =
        s.indices.maxOfOrNull { i -> s.lastIndexOf(s[i], s.length - 1) - i - 1 } ?: -1
}
