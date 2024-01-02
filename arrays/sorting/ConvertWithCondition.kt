package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */

private class ConvertWithCondition {
    fun findMatrix(nums: IntArray): List<List<Int>> =
        nums.fold(mutableListOf()) { acc: MutableList<List<Int>>, num ->
            acc.apply {
                firstOrNull { num !in it }?.let { it as MutableList<Int> }?.add(num) ?: add(mutableListOf(num))
            }
        }
}
