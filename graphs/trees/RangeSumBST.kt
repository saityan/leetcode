package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */

private class RangeSumBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var res = 0

        fun preOrderTraversal(node: TreeNode?) {
            if (node != null) {
                if (node.`val` in low..high) {
                    res += node.`val`
                }
                preOrderTraversal(node.left)
                preOrderTraversal(node.right)
            }
        }

        preOrderTraversal(root)

        return res
    }
}
