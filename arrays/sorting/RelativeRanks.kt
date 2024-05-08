package leetcode.arrays.sorting

// https://leetcode.com/problems/relative-ranks/

private class RelativeRanks {
    fun findRelativeRanks(score: IntArray): Array<String> {
        if (score.isEmpty()) return emptyArray()

        val sortedScores = score.sortedArrayDescending()
        val map = HashMap<Int, String>()

        for (i in sortedScores.indices) {
            when {
                i > 2 -> map[sortedScores[i]] = (i + 1).toString()
                i == 0 -> map[sortedScores[i]] = "Gold Medal"
                i == 1 -> map[sortedScores[i]] = "Silver Medal"
                else -> map[sortedScores[i]] = "Bronze Medal"
            }
        }

        val result = Array(score.size) { "" }
        for (i in score.indices) {
            map[score[i]]?.let {
                result[i] = it
            }
        }

        return result
    }
}
