package leetcode

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * There are n computers numbered from 0 to n - 1, connected by ethernet cables connections forming a network, where
 * connections[i] = [ai, bi] represents a connection between computers ai and bi.
 * Any computer can reach any other computer directly or indirectly through the network.

 * You are given an initial computer network connections.
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.

 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.
 */

import java.util.*

private class MakeNetworkConnected {
    private fun makeConnected(n: Int, connections: Array<IntArray>): Int {

        if (connections.size < n - 1)
            return -1

        val graph = Array(n) {
            LinkedList<Int>()
        }
        val visited = BooleanArray(n)

        for (connection in connections) {
            graph[connection[0]].add(connection[1])
            graph[connection[1]].add(connection[0])
        }

        fun markVisited(computer: Int) {
            if (visited[computer])
                return
            visited[computer] = true
            graph[computer].forEach {
                markVisited(it)
            }
        }

        var networks = 0
        for (computer in 0 until n) {
            if (!visited[computer]) {
                networks++
                markVisited(computer)
            }
        }
        return networks - 1
    }
}
