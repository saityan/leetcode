package leetcode.graphs.search

import java.util.*

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph
 *
 * return true if there is a valid path from source to destination, or false otherwise.
 */

private class FindingPath {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        if (source == destination) return true

        val graph = Array(n) { mutableListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge
            graph[u].add(v)
            graph[v].add(u)
        }

        val visited = BooleanArray(n)
        val queue = LinkedList<Int>()
        queue.offer(source)
        visited[source] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == destination) return true

            for (next in graph[node]) {
                if (!visited[next]) {
                    queue.offer(next)
                    visited[next] = true
                }
            }
        }

        return false
    }
}
