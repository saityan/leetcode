package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 */

private class MaximumDifference {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        fun dfs(node: TreeNode?, minValue: Int, maxValue: Int): Int {
            if (node == null) {
                return maxValue - minValue
            }

            val newMinValue = minOf(minValue, node.`val`)
            val newMaxValue = maxOf(maxValue, node.`val`)

            val leftDiff = dfs(node.left, newMinValue, newMaxValue)
            val rightDiff = dfs(node.right, newMinValue, newMaxValue)

            return maxOf(leftDiff, rightDiff)
        }

        return dfs(root, root.`val`, root.`val`)
    }
}
