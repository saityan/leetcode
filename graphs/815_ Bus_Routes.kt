package leetcode.graphs

import java.util.*

/**
 * https://leetcode.com/problems/bus-routes/
 *
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 */

private class `815_ Bus_Routes` {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        val graph: HashMap<Int, HashSet<Int>> = HashMap()

        for ((index, route) in routes.withIndex()) {
            for (stop in route) {
                graph.computeIfAbsent(stop) {
                    HashSet()
                }.add(index)
            }
        }

        val visitedStops = HashSet<Int>()
        val visitedBuses = HashSet<Int>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(source, 0))

        while (queue.isNotEmpty()) {
            val (current, result) = queue.poll()

            if (current == target) {
                return result
            }

            for (bus in graph[current] ?: emptySet()) {
                if (bus !in visitedBuses) {
                    visitedBuses.add(bus)
                    for (nextStop in routes[bus]) {
                        if (nextStop !in visitedStops) {
                            visitedStops.add(nextStop)
                            queue.offer(Pair(nextStop, result + 1))
                        }
                    }
                }
            }
        }

        return -1
    }
}
