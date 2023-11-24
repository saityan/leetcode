package leetcode.arrays.sorting;

/**
 * leetcode.com/problems/maximum-number-of-coins-you-can-get/submissions/
 */

import java.util.Arrays;

class MaximumCoins {
    public int maxCoins(int[] piles) {
        //Check validity
        if (piles.length % 3 !=0)
            return -1;

        int result = 0;

        //Copy the data (we shouldn't change the original data)
        int[] sortedPiles = Arrays.copyOf(piles, piles.length);
        Arrays.sort(sortedPiles);

        //Iterate through the new array
        for (int i = sortedPiles.length - 1; i >= sortedPiles.length / 3; i -= 2)
            result += sortedPiles[i - 1];

        return result;
    }
}
