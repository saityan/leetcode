package leetcode.bits

private class MaximumOdd {
    fun maximumOddBinaryNumber(s: String): String {

        val numberOfOnes = s.count { it == '1' }

        return StringBuilder().apply {
            repeat(numberOfOnes - 1) { append('1') }
            repeat(s.length - numberOfOnes) { append('0') }
            append('1')
        }.toString()
    }
}
