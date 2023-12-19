package leetcode.matrix

/**
 * https://leetcode.com/problems/transpose-matrix/
 */

private class TransposeMatrix {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> =
        matrix[0].indices.map { i ->
            matrix.map {
                it[i]
            }.toIntArray()
        }.toTypedArray()
}
