package leetcode.graphs.trees.dfs

import leetcode.graphs.trees.TreeNode

// https://leetcode.com/problems/evaluate-boolean-binary-tree/

private class BooleanTree {
    fun evaluateTree(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?): Boolean {
            if (node != null) {
                when (node.`val`) {
                    0 -> return false
                    1 -> return true
                    2 -> return dfs(node.left) || dfs(node.right)
                    3 -> return dfs(node.left) && dfs(node.right)
                }
            }

            return false
        }

        return dfs(root)
    }
}
