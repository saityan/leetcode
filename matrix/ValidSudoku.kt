package leetcode.matrix

/**
 * https://leetcode.com/problems/valid-sudoku
 */

private class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (board.size != 9 || board[0].size != 9) return false

        val rows = HashMap<Int, MutableList<Char>>()
        val cols = HashMap<Int, MutableList<Char>>()
        val quads = HashMap<Int, MutableList<Char>>()

        for (i in 0..8) {
            for (j in 0..8) {
                val letter = board[i][j]
                if (letter == '.') {
                    continue
                }
                rows.getOrPut(i) { mutableListOf() }
                rows[i]?.let {
                    if (it.contains(letter)) {
                        return false
                    } else {
                        it.add(letter)
                    }
                }

                cols.getOrPut(j) { mutableListOf() }
                cols[j]?.let {
                    if (it.contains(letter)) {
                        return false
                    } else {
                        it.add(letter)
                    }
                }

                val quadIndex = (i / 3) * 3 + (j / 3)
                quads.getOrPut(quadIndex) { mutableListOf() }
                quads[quadIndex]?.let {
                    if (it.contains(letter)) {
                        return false
                    } else {
                        it.add(letter)
                    }
                }
            }
        }

        return true
    }
}
