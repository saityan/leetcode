package leetcode.graphs.tries

// https://leetcode.com/problems/replace-words

private class ReplaceWords {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val words = sentence.split(" ").toMutableList()

        val trie = Trie()
        for (root in dictionary) {
            trie.insert(root)
        }

        for (i in words.indices) {
            words[i] = trie.getShortestRoot(words[i])
        }

        return words.joinToString(" ")
    }
}

private class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

private class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children.computeIfAbsent(char) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }

    fun getShortestRoot(word: String): String {
        var currentNode = root
        val prefix = StringBuilder()

        for (char in word) {
            currentNode.children[char]?.let {
                currentNode = it
                prefix.append(char)
                if (currentNode.isEndOfWord) {
                    return prefix.toString()
                }
            } ?: break
        }

        return word
    }
}
