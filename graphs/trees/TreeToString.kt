package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */

private class TreeToString {
    fun tree2str(root: TreeNode?): String {

        if (root == null) return ""

        val result = StringBuilder()

        fun preOrderTraversal(node: TreeNode?, sb: StringBuilder) {
            if (node != null) {
                sb.append("(${node.`val`}")

                when {
                    node.left == null && node.right != null -> sb.append("()")
                    node.left != null -> preOrderTraversal(node.left, sb)
                }

                if (node.right != null) {
                    preOrderTraversal(node.right, sb)
                }

                sb.append(")")
            }
        }

        preOrderTraversal(root, result)

        result.deleteCharAt(0)
        result.deleteCharAt(result.length - 1)

        return result.toString()
    }
}

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
