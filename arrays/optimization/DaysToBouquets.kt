package leetcode.arrays.optimization

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

private class DaysToBouquets {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (m.toLong() * k.toLong() > bloomDay.size) return -1

        var start = bloomDay.minOrNull() ?: 0
        var end = bloomDay.maxOrNull() ?: 0

        while (start < end) {
            val middle = (start + end) / 2
            if (canMakeBouquets(bloomDay, middle, m, k)) {
                end = middle
            } else {
                start = middle + 1
            }
        }

        return start
    }

    private fun canMakeBouquets(bloomDay: IntArray, day: Int, m: Int, k: Int): Boolean {
        var bouquets = 0
        var flowers = 0

        for (bloom in bloomDay) {
            if (bloom <= day) {
                flowers++
                if (flowers == k) {
                    bouquets++
                    flowers = 0
                    if (bouquets == m) {
                        return true
                    }
                }
            } else {
                flowers = 0
            }
        }

        return bouquets >= m
    }
}
