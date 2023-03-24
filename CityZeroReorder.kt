package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way
 * to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0.
 * Return the minimum number of edges changed.

 * It's guaranteed that each city can reach city 0 after reorder.
 */

private class CityZeroReorder {
    data class Path(val destination: Int, val isReversed: Boolean)

    fun minReorder(n: Int, connections: Array<IntArray>): Int {

        val paths = Array(n) {
            LinkedList<Path>()
        }

        for (connection in connections) {
            paths[connection[0]].add(Path(connection[1], true))
            paths[connection[1]].add(Path(connection[0], false))
        }

        val visited = BooleanArray(n)
        var reversals = 0

        val stack = Stack<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val size = stack.size
            for (i in 0 until size) {
                val nextCity = stack.pop()
                if (visited[nextCity])
                    continue
                visited[nextCity] = true

                paths[nextCity].forEach {
                    if (!visited[it.destination]) {
                        stack.add(it.destination)
                        if (it.isReversed)
                            reversals++
                    }
                }
            }
        }
        return reversals
    }
}
