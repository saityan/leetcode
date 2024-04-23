package leetcode.graphs.path

import java.util.*

/**
 * https://leetcode.com/problems/minimum-height-trees
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 */

private class MinimumHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val graph = Array(n) { mutableListOf<Int>() }
        val weight = IntArray(n)

        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
            weight[edge[0]]++
            weight[edge[1]]++
        }

        val queue = LinkedList<Int>()
        for (i in 0 until n) {
            if (weight[i] == 1) {
                queue.offer(i)
            }
        }

        var remainingNodes = n
        while (remainingNodes > 2) {
            val size = queue.size
            remainingNodes -= size
            repeat(size) {
                val node = queue.poll()
                for (neighbor in graph[node]) {
                    weight[neighbor]--
                    if (weight[neighbor] == 1) {
                        queue.offer(neighbor)
                    }
                }
            }
        }

        return queue.toList()
    }
}
