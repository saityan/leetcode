package leetcode.strings.transposal

/**
 * https://leetcode.com/problems/make-the-string-great/
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 */

private class GreatString {
    fun makeGood(s: String): String {
        val result = StringBuilder().append(s)
        var isChanged = true

        while (isChanged) {
            if (result.isEmpty()) return result.toString()
            isChanged = false
            val size = result.length

            for (i in 0 until size - 1) {
                when {
                    result[i].isLowerCase() ->
                        if (result[i + 1].isUpperCase() && result[i + 1].lowercaseChar() == result[i]) {
                            result.delete(i, i + 2)
                            isChanged = true
                            break
                        }

                    result[i].isUpperCase() ->
                        if (result[i + 1].isLowerCase() && result[i + 1].uppercaseChar() == result[i]) {
                            result.delete(i, i + 2)
                            isChanged = true
                            break
                        }
                }
            }
        }

        return result.toString()
    }
}
