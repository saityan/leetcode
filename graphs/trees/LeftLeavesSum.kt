package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 */

private class LeftLeavesSum {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        root ?: return 0

        var result = 0

        fun isLeaf(node: TreeNode): Boolean {
            return node.left == null && node.right == null
        }

        if (root.left != null && isLeaf(root.left!!)) {
            result += root.left!!.`val`
        }

        result += sumOfLeftLeaves(root.left)
        result += sumOfLeftLeaves(root.right)

        return result
    }
}