package leetcode.arrays.search

// https://leetcode.com/problems/single-number-iii

private class TwoSingles {
    fun singleNumber(nums: IntArray): IntArray {
        var xorResult = 0
        for (num in nums) {
            xorResult = xorResult xor num
        }

        val diffBit = xorResult and -xorResult

        var a = 0
        var b = 0
        for (num in nums) {
            if ((num and diffBit) == 0) {
                a = a xor num
            } else {
                b = b xor num
            }
        }

        return intArrayOf(a, b)
    }
}
