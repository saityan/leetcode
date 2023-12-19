package leetcode.matrix

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */

private class SpecialPositionsTotal {
    fun numSpecial(mat: Array<IntArray>): Int {
        if (mat.isEmpty() || mat[0].isEmpty())
            return 0

        val rowSums = IntArray(mat.size)
        val colSums = IntArray(mat[0].size)

        for (i in mat.indices)
            for (j in mat[0].indices) {
                rowSums[i] += mat[i][j]
                colSums[j] += mat[i][j]
            }

        var result = 0

        for (i in mat.indices)
            for (j in mat[0].indices)
                if (mat[i][j] == 1 && rowSums[i] == 1 && colSums[j] == 1)
                    result++

        return result
    }
}
