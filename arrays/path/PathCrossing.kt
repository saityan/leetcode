package leetcode.arrays.path

/**
 * https://leetcode.com/problems/path-crossing/
 */

private class PathCrossing {

    fun isPathCrossing(path: String): Boolean {

        if(path.length < 2) return false

        val visited = mutableSetOf<Pair<Int, Int>>()
        visited.add(Pair(0, 0))

        var x = 0
        var y = 0

        for (c in path) {
            when(c) {
                'E' -> x++
                'W' -> x--
                'N' -> y++
                'S' -> y--
            }
            if (!visited.add(Pair(x, y))) return true
        }

        return false
    }
}
