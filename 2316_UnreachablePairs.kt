package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
 * You are given a 2D integer array edges, where edges[i] = [ai, bi] denote that
 * there exists an undirected edge connecting nodes ai and bi.

 * Return the number of pairs of different nodes that are unreachable from each other.
 */

private class UnreachablePairs {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {

        val graph = Array(n) {
            LinkedList<Int>()
        }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        val visited = BooleanArray(n)

        fun visit(node: Int): Int {
            if (node == n || visited[node]) return 0
            visited[node] = true
            return 1 + (graph[node].map { visit(it) }.sum())
        }

        fun inspectNode(node: Int, totalGraphs: Int = 0, seenNodes: Int = 0, sum: Long = 0): Long {
            if (node == n) return if (totalGraphs == 1) 0 else sum
            if (visited[node]) return inspectNode(node + 1, totalGraphs, seenNodes, sum)
            val reachableNodes = visit(node)

            return inspectNode(
                node + 1,
                totalGraphs + 1,
                seenNodes + reachableNodes,
                seenNodes.toLong() * reachableNodes.toLong() + sum
            )
        }

        return inspectNode(0)
    }
}
