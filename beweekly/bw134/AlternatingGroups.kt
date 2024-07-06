package leetcode.beweekly.bw134

// https://leetcode.com/contest/biweekly-contest-134/problems/alternating-groups-i/

private class AlternatingGroups {
    fun numberOfAlternatingGroups(colors: IntArray): Int {
        var result = 0
        val size = colors.size
        if (colors.size < 3) return result

        for (i in 0 until size) {
            if ((colors[i] == 0 && colors[(i + 1) % size]  == 1 && colors[(i + 2)% size] == 0) ||
                        colors[i] == 1 && colors[(i + 1) % size] == 0 && colors[(i + 2) % size] == 1) {
                result++
            }
        }

        return result
    }
}
