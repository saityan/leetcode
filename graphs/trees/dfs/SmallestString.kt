package leetcode.graphs.trees.dfs

import leetcode.graphs.trees.TreeNode
import java.util.*

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 *
 * Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 */

private class SmallestString {
    fun smallestFromLeaf(root: TreeNode?): String {
        root ?: return ""

        val priorityQueue = PriorityQueue<Pair<String, StringBuilder>>(compareBy { it.first })

        fun traverse(node: TreeNode, sb: StringBuilder) {
            val newSb = StringBuilder(sb)
            newSb.append((node.`val` + 'a'.code).toChar())
            if (node.left == null && node.right == null) {
                priorityQueue.add(Pair(newSb.reverse().toString(), newSb))
            } else {
                node.left?.let { traverse(it, StringBuilder(newSb)) }
                node.right?.let { traverse(it, StringBuilder(newSb)) }
            }
        }

        traverse(root, StringBuilder())

        return priorityQueue.poll().first
    }
}
