package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 *
 * Given the root of a binary tree and two integers val and depth,
 * add a row of nodes with value at the given depth.
 */

private class AdditionalRow {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1) {
            val newRoot = TreeNode(`val`)
            newRoot.left = root
            return newRoot
        }

        fun traverse(node: TreeNode?, currentDepth: Int) {
            if (node == null || currentDepth > depth) return

            if (depth == currentDepth + 1) {
                val tempLeft = node.left
                val tempRight = node.right
                node.left = TreeNode(`val`)
                node.right = TreeNode(`val`)
                node.left?.left = tempLeft
                node.right?.right = tempRight
            } else {
                traverse(node.left, currentDepth + 1)
                traverse(node.right, currentDepth + 1)
            }
        }

        traverse(root, 1)

        return root
    }
}
