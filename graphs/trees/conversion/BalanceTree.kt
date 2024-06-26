package leetcode.graphs.trees.conversion

import leetcode.graphs.trees.TreeNode

// https://leetcode.com/problems/balance-a-binary-search-tree

class BalanceTree {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val sortedNodes = mutableListOf<Int>()
        traverseInOrder(root, sortedNodes)
        return constructBST(sortedNodes, 0, sortedNodes.lastIndex)
    }

    private fun traverseInOrder(node: TreeNode?, list: MutableList<Int>) {
        node?.let {
            traverseInOrder(it.left, list)

            list.add(it.`val`)

            traverseInOrder(it.right, list)
        }
    }

    private fun constructBST(sortedNodes: List<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val middle = start + (end - start) / 2
        val node = TreeNode(sortedNodes[middle])

        node.left = constructBST(sortedNodes, start, middle - 1)
        node.right = constructBST(sortedNodes, middle + 1, end)

        return node
    }
}
