package leetcode.bits

private class HammingWeight {
    fun hammingWeight(n: Int): Int = Integer.toBinaryString(n).count { it == '1' }
}
