package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 *
 * Return the total sum of all root-to-leaf numbers
 */

private class RootToLeaf {
    fun sumNumbers(root: TreeNode?): Int {
        root ?: return 0

        var result = 0

        fun traverse(node: TreeNode?, currentSum: Int) {
            node ?: return

            if (node.left == null && node.right == null) {
                result += (currentSum.toString() + node.`val`.toString()).toInt()
                return
            }

            node.left?.let {
                traverse(it, (currentSum.toString() + node.`val`.toString()).toInt())
            }
            node.right?.let {
                traverse(it, (currentSum.toString() + node.`val`.toString()).toInt())
            }
        }

        traverse(root, 0)

        return result
    }
}
