package leetcode.graphs.trees

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

private class MaximumDepth {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            val leftDepth = dfs(node.left)
            val rightDepth = dfs(node.right)

            return max(leftDepth, rightDepth) + 1
        }

        return dfs(root)
    }
}
