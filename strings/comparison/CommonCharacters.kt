package leetcode.strings.comparison

// https://leetcode.com/problems/find-common-characters

class CommonCharacters {
    fun commonChars(words: Array<String>): List<String> {
        if (words.isEmpty()) return emptyList()
        if (words.size == 1) return words[0].map { it.toString() }

        val sample = words[0].groupingBy { it }.eachCount().toMutableMap()

        for (i in 1 until words.size) {
            val freqMap = words[i].groupingBy { it }.eachCount()

            sample.entries.retainAll { (k, v) ->
                freqMap.contains(k).also {
                    if (it) sample[k] = minOf(v, freqMap.getOrDefault(k, 0))
                }
            }
        }

        return sample.flatMap { (key, value) -> List(value) { key.toString() } }
    }
}
