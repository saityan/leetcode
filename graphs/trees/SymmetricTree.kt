package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/symmetric-tree
 */

private class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: throw IllegalArgumentException("TreeNode was expected, but null was given")

        fun isMirror(node1: TreeNode?, node2: TreeNode?): Boolean {
            if (node1 == null && node2 == null) return true
            if (node1 == null || node2 == null || node1.`val` != node2.`val`) return false
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)
        }

        return isMirror(root, root)
    }
}
