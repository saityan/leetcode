package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */

private class TreeInversion {
    fun invertTree(root: TreeNode?): TreeNode? {

        fun traverse(node: TreeNode?) {
            node ?: return

            val tempNode = node.left
            node.left = node.right
            node.right = tempNode

            traverse(node.left)
            traverse(node.right)
        }

        traverse(root)

        return root
    }
}
