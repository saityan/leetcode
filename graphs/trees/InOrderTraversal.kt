package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

private class InOrderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun traverse(node: TreeNode?) {
            if (node != null) {
                traverse(node.left)
                result.add(node.`val`)
                traverse(node.right)
            }
        }

        traverse(root)
        return result
    }
}
