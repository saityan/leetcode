package leetcode.graphs.trees.bfs

import leetcode.graphs.trees.TreeNode
import java.util.*

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 */

private class AverageLevelValue {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = mutableListOf<Double>()
        root ?: return result.toDoubleArray()

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            var levelSum = 0.0
            val size = queue.size

            for (i in 0 until size) {
                val node = queue.poll()
                levelSum += node.`val`
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }

            result.add(levelSum / size)
        }

        return result.toDoubleArray()
    }
}
