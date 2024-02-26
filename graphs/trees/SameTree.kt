package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/same-tree/
 */

private class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return if (p == null && q == null) {
            true
        } else if (p == null || q == null) {
            false
        } else if (p.`val` != q.`val`) {
            false
        } else {
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }
}
