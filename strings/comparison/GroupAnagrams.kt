package leetcode.strings.comparison

/**
 * https://leetcode.com/problems/group-anagrams
 */

private class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val collection = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val sortedStr = str.toCharArray().sorted().joinToString("")
            collection.getOrPut(sortedStr) { mutableListOf() }.add(str)
        }

        return collection.values.toList()
    }
}
