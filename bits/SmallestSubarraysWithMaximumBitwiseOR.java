package leetcode.bits;

import java.util.Arrays;

/**
 * leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/
 */

class SmallestSubarraysWithMaximumBitwiseOR {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] maxOR = new int[n];
        int[] result = new int[n];
        int[] lastPos = new int[32];
        Arrays.fill(lastPos, -1);

        maxOR[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxOR[i] = nums[i] | maxOR[i + 1];
        }

        int maxBit = 31 - Integer.numberOfLeadingZeros(maxOR[0]);

        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit <= maxBit; bit++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    lastPos[bit] = i;
                }
            }

            int farthestJ = i;
            for (int bit = 0; bit <= maxBit; bit++) {
                if ((maxOR[i] & (1 << bit)) != 0 && lastPos[bit] != -1) {
                    farthestJ = Math.max(farthestJ, lastPos[bit]);
                }
            }

            result[i] = farthestJ - i + 1;
        }

        return result;
    }
}
