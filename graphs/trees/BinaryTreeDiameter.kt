package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/diameter-of-binary-tree
 */

private class BinaryTreeDiameter {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0

        fun dfs (treeNode: TreeNode?) : Int {
            return if (treeNode == null) {
                0
            } else {
                val diameterLeft = dfs(treeNode.left)
                val diameterRight = dfs(treeNode.right)
                diameter = maxOf(diameter, diameterLeft + diameterRight)
                return 1 + maxOf(diameterLeft, diameterRight)
            }
        }

        dfs(root)
        return diameter
    }
}
