package leetcode.grids.path

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 */

private class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty() || board[0].isEmpty()) return false

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (dfs(board, i, j, word, 0)) return true
            }
        }

        return false
    }

    private fun dfs(board: Array<CharArray>, row: Int, col: Int, word: String, index: Int): Boolean {
        if (index == word.length) return true
        if (row !in board.indices || col !in board.indices || board[row][col] != word[index]) {
            return false
        }

        val temp = board[row][col]
        board[row][col] = ' '

        val found = dfs(board, row + 1, col, word, index + 1) ||
                dfs(board, row - 1, col, word, index + 1) ||
                dfs(board, row, col + 1, word, index + 1) ||
                dfs(board, row, col - 1, word, index + 1)

        board[row][col] = temp

        return found
    }
}
