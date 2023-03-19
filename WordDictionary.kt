package leetcode

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Search returns true if there is any string in the data structure that matches word or false otherwise.
 * Word may contain dots '.' where dots can be matched with any letter.
 */
class WordTree() {
    var children = HashMap<Char, WordTree>()
    var isWord: Boolean = false
}

class WordDictionary() {
    private val root = WordTree()

    fun addWord(word: String) {
        var node = root
        val chars = word.toLowerCase().toCharArray()
        for (i in chars.indices) {
            val letter = chars[i]
            if (!node.children.containsKey(letter))
                node.children[letter] = WordTree()
            node.children[letter]?.let { node = it }
        }
        node.isWord = true
    }

    fun search(word: String): Boolean = isMatched(word, root,0)

    private fun isMatched(word:String, node: WordTree, index: Int) : Boolean {
        if (index == word.length)
            return node.isWord
        val chars = word.toLowerCase().toCharArray()
        val letter = chars[index]

        if (letter == '.') {
            for (child in node.children.values) {
                if (isMatched(word, child, index + 1))
                    return true
            }
            return false
        } else {
            val child = node.children[letter] ?: return false
            return isMatched(word, child, index + 1)
        }
    }
}
