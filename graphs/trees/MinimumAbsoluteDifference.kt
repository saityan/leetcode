package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 *
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 */

private class MinimumAbsoluteDifference {
    fun getMinimumDifference(root: TreeNode?): Int {
        root ?: return Int.MAX_VALUE

        var minDiff = Int.MAX_VALUE
        var previous: TreeNode? = null

        fun getMinimumDifference(node: TreeNode?): Int {
            node ?: return minDiff

            getMinimumDifference(node.left)

            previous?.let {
                minDiff = minOf(minDiff, node.`val` - previous!!.`val`)
            }

            previous = node
            getMinimumDifference(node.right)

            return minDiff
        }

        return getMinimumDifference(root)
    }
}
