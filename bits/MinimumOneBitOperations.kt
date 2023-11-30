package leetcode.bits

/**
 * https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
 */

private class MinimumOneBitOperations {
    private fun minimumOneBitOperations(n: Int): Int =
        run {
            var result = n
            result.xor(result shr 16)
                .also { result = it }.xor(result shr 8)
                .also { result = it }.xor(result shr 4)
                .also { result = it }.xor(result shr 2)
                .also { result = it }.xor(result shr 1)
        }
}
