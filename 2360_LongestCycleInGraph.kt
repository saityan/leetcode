package leetcode

/**
 * https://leetcode.com/problems/longest-cycle-in-a-graph/
 *
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i].
 * If there is no outgoing edge from node i, then edges[i] == -1.
 *
 * Return the length of the longest cycle in the graph. If no cycle exists, return -1.
 * A cycle is a path that starts and ends at the same node.
 */

private class LongestCycleInGraph {
    fun longestCycle(edges: IntArray): Int {

        var visited = BooleanArray(edges.size)
        val seen = BooleanArray(edges.size)

        fun traverseFromEdge(start: Int, n: Int, steps: Int = 0) : Int {
            if (seen[start] || seen[n])
                return -1
            if (visited[n] && n != start) {
                seen[start] = true
                visited = BooleanArray(edges.size)
                return traverseFromEdge(n, n)
            }
            if (visited[n]) {
                for (l in visited.indices)
                    if (!seen[l])
                        seen[l] = visited[l]
                visited = BooleanArray(edges.size)
                return steps
            }
            if (edges[n] == -1)
                return -1
            visited[n] = true
            return traverseFromEdge(start, edges[n], steps + 1)
        }

        var maxLength = -1
        for (k in edges.indices) {
            val length = traverseFromEdge(k, k)
            if (length > 0 && length > maxLength)
                maxLength = length
        }
        return maxLength
    }
}
