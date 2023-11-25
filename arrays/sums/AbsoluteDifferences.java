package leetcode.arrays.sums;

/**
 * leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array
 */

import java.util.Arrays;

class AbsoluteDifferences {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sumLeft = 0;
        int sumRight = Arrays.stream(nums).sum();
        int size = nums.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = Math.abs(nums[i] * (size - i) - sumRight) + Math.abs(nums[i] * i - sumLeft);
            sumLeft += nums[i];
            sumRight -= nums[i];
        }

        return result;
    }
}
