package leetcode.graphs.search

/**
 * https://leetcode.com/problems/destination-city/
 */

class DestinationCity {
    fun destCity(paths: List<List<String>>): String =
        paths.associate { it[0] to it[1] }.let { map ->
            paths.firstOrNull { !map.containsKey(it[1]) }?.get(1) ?: ""
        }
}
