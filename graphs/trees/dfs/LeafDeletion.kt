package leetcode.graphs.trees.dfs

import leetcode.graphs.trees.TreeNode

// https://leetcode.com/problems/delete-leaves-with-a-given-value

private class LeafDeletion {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {

        fun traverse(node: TreeNode?): TreeNode? {
            node ?: return null

            if (node.left != null) {
                node.left = traverse(node.left)
            }

            if (node.right != null) {
                node.right = traverse(node.right)
            }

            return if (node.`val` == target && node.left == null && node.right == null) {
                null
            } else {
                node
            }
        }

        return traverse(root)
    }
}
