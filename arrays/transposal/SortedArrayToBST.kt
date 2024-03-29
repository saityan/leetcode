package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to
 * a height-balanced binary search tree.
 */

private class SortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null

        return sortedArrayToBST(nums, 0, nums.size - 1)
    }

    private fun sortedArrayToBST(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val mid = left + (right - left) / 2
        val node = TreeNode(nums[mid])

        node.left = sortedArrayToBST(nums, left, mid - 1)
        node.right = sortedArrayToBST(nums, mid + 1, right)

        return node
    }
}
