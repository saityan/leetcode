package leetcode

import java.lang.Integer.min
import java.util.LinkedList
import java.util.Queue

class TwoCitiesPath {

    data class Road(val start: Int, val end: Int, val distance: Int)

    fun minScore(n: Int, roads: Array<IntArray>): Int {

        sortRoads(roads)

        var minRouteDistance = Int.MAX_VALUE
        val queue: Queue<Int> = LinkedList()
        val isVisited = BooleanArray(n + 1)

        queue.offer(1)

        val routes = LinkedList<Road>()
        for (route in roads) {
            routes.add(
                Road(
                    route[0],
                    route[1],
                    route[2]
                )
            )
            routes.add(
                Road(
                    route[1],
                    route[0],
                    route[2]
                )
            )
            minRouteDistance = min(route[2], minRouteDistance)
        }

        var minDistance = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val node = queue.poll()

            isVisited[node] = true

            for (route in routes)
                if (route.start == node && !isVisited[route.end]) {
                    queue.offer(route.end)
                    minDistance = min(route.distance, minDistance)
                }
            routes.removeIf { it.start == node }
            if (minDistance == minRouteDistance)
                break
        }
        return minDistance
    }

    private fun sortRoads(roads: Array<IntArray>) {
        for (road in roads)
            if (road[0] > road[1]) {
                val temp = road[1]
                road[1] = road[0]
                road[0] = temp
            }
    }
}
