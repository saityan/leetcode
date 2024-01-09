package leetcode.graphs.trees

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */

private class LeafSimilar {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {

        val firstLeaves = ArrayList<Int>()
        val secondLeaves = ArrayList<Int>()

        fun traverse(node: TreeNode?, list: ArrayList<Int>) {
            if (node != null) {
                if (isLeaf(node)) {
                    list.add(node.`val`)
                }
                traverse(node.left, list)
                traverse(node.right, list)
            }
        }

        traverse(root1, firstLeaves)
        traverse(root2, secondLeaves)

        return firstLeaves == secondLeaves
    }

    fun isLeaf(node: TreeNode?) : Boolean {
        return if (node == null) false
        else node.left == null && node.right == null
    }
}
