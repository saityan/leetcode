package leetcode.bits;

/**
 * leetcode.com/problems/count-of-matches-in-tournament/
 */

class CountOfMatches {
    public int numberOfMatches(int n) {
        int result = 0;
        while (n > 1) {
            result += n >> 1;
            n = (n + 1) >> 1;
        }
        return result;
    }
}
