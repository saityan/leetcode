package leetcode.dp

/**
 * https://leetcode.com/problems/counting-bits/
 */

private class CountingBits {
    fun countBits(n: Int): IntArray {
        val res = IntArray(n + 1)

        for (i in 1..n) {
            res[i] = res[i / 2] + (i and 1)
        }

        return res
    }
}
