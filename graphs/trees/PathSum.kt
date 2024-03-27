package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/path-sum/
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 */

private class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false

        fun traverse(node: TreeNode?, currentSum: Int) : Boolean {
            if (node == null) {
                return false
            }

            if (node.left == null && node.right == null && currentSum + node.`val` == targetSum) {
                return true
            }

            return traverse(node.left, currentSum + node.`val`) ||
                    traverse(node.right, currentSum + node.`val`)
        }

        return traverse(root, 0)
    }
}
