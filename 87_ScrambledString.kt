package leetcode

private class ScrambledString {
    fun isScramble(s1: String, s2: String): Boolean {

        if (s1.isEmpty() || s2.isEmpty()) {
            return false
        }

        val l = s1.length

        val map = Array(l + 1) {
            Array(l) {
                BooleanArray(l)
            }
        }

        for (i in 0 until l) {
            for (j in 0 until l) {
                map[1][i][j] = s1[i] == s2[j]
            }
        }

        for (length in 2..l) {
            for (i in 0 until l + 1 - length) {
                for (j in 0 until l + 1 - length) {
                    for (newLength in 1 until length) {
                        val first = map[newLength][i]
                        val second = map[length - newLength][i + newLength]
                        map[length][i][j] = map[length][i][j] || first[j] && second[j + newLength]
                        map[length][i][j] = map[length][i][j] || first[j + length - newLength] && second[j]
                    }
                }
            }
        }
        return map[l][0][0]
    }
}
