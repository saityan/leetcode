package leetcode.graphs.trees

import java.util.*

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */

private class BottomLeft {
    fun findBottomLeftValue(root: TreeNode?): Int {
        root ?: throw IllegalArgumentException("TreeNode was expected, but null was given")

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        var result = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (i == 0) {
                    result = node.`val`
                }
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }

        return result
    }
}
