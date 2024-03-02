package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array
 */

private class SortedSquares {
    fun sortedSquares(nums: IntArray): IntArray =
        nums.map { it * it }.sorted().toIntArray()
}
