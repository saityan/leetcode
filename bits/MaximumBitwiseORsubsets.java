package leetcode.bits;

/**
 * leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets
 */

// Note: use only for small arrays (length < 20)
class MaximumBitwiseORsubsets {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num: nums) {
            maxOR |= num;
        }

        int result = 0;
        int size = nums.length;
        for (int mask = 1; mask < (1 << size); mask++) {
            int subsetMaxOR = 0;
            for (int i = 0; i < size; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetMaxOR |= nums[i];
                    if (subsetMaxOR == maxOR) {
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
