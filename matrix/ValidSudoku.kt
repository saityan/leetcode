package leetcode.matrix

/**
 * https://leetcode.com/problems/valid-sudoku
 */

private class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (board.size != 9 || board[0].size != 9) return false

        val rows = HashMap<Int, MutableSet<Char>>()
        val cols = HashMap<Int, MutableSet<Char>>()
        val quads = HashMap<Int, MutableSet<Char>>()

        for (i in 0..8) {
            for (j in 0..8) {
                val letter = board[i][j]
                if (letter == '.') {
                    continue
                }
                rows.getOrPut(i) { mutableSetOf() }
                rows[i]?.let {
                    if (!it.add(letter)) {
                        return false
                    }
                }

                cols.getOrPut(j) { mutableSetOf() }
                cols[j]?.let {
                    if (!it.add(letter)) {
                        return false
                    }
                }

                val quadIndex = (i / 3) * 3 + (j / 3)
                quads.getOrPut(quadIndex) { mutableSetOf() }
                quads[quadIndex]?.let {
                    if (!it.add(letter)) {
                        return false
                    }
                }
            }
        }

        return true
    }
}
