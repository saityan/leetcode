package leetcode.strings.comparison

private class IsPalindrome {
    fun isPalindrome(s: String): Boolean {

        val mutatedS = s.replace(Regex("[^a-zA-Z\\d]"), "").lowercase()

        for (i in 0 until mutatedS.length / 2) {
            if (mutatedS[i] != mutatedS[mutatedS.length - 1 - i]) {
                return false
            }
        }

        return true
    }
}
