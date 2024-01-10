package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 */

private class InfectedTree {
    private var maxDistance = 0

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        traverse(root, start)
        return maxDistance
    }

    private fun traverse(root: TreeNode?, start: Int): Int {
        if (root == null) {
            return 0
        }

        val depth: Int
        val leftDepth = traverse(root.left, start)
        val rightDepth = traverse(root.right, start)

        if (root.`val` == start) {
            maxDistance = leftDepth.coerceAtLeast(rightDepth)
            depth = -1
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = maxOf(leftDepth, rightDepth) + 1
        } else {
            val distance = kotlin.math.abs(leftDepth) + kotlin.math.abs(rightDepth)
            maxDistance = maxOf(maxDistance, distance)
            depth = minOf(leftDepth, rightDepth) - 1
        }

        return depth
    }
}
