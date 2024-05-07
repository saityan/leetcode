package leetcode.graphs.trees.bfs

import leetcode.graphs.trees.TreeNode
import java.util.LinkedList

// https://leetcode.com/problems/binary-tree-right-side-view

private class RightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root ?: return result

        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var rightmostNodeValue = 0

            for (i in 0 until size) {
                val node = queue.poll()
                if (i == size - 1) {
                    rightmostNodeValue = node.`val`
                }
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            result.add(rightmostNodeValue)
        }

        return result
    }
}
