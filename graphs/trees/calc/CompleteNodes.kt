package leetcode.graphs.trees.calc

import leetcode.graphs.trees.TreeNode

/**
 * https://leetcode.com/problems/count-complete-tree-nodes
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * Design an algorithm that runs in less than O(n) time complexity.
 */

private class CompleteNodes {
    fun countNodes(root: TreeNode?): Int {
        root ?: return 0

        fun depth(node: TreeNode?): Int {
            var depth = 0
            var curr = node
            while (curr != null) {
                depth++
                curr = curr.left
            }
            return depth
        }

        var depth = depth(root)
        var count = 0
        var node = root
        while (node != null) {
            if (depth(node.right) == depth - 1) {
                count += 1 shl (depth - 1)
                node = node.right
            } else {
                count += 1 shl (depth - 2)
                node = node.left
            }
            depth--
        }
        return count
    }
}
