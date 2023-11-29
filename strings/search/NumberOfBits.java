package leetcode.strings.search;

/**
 * leetcode.com/problems/number-of-1-bits/
 */

class NumberOfBits {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
