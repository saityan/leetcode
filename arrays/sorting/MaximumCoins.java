package leetcode.arrays.sorting;

/**
 * leetcode.com/problems/maximum-number-of-coins-you-can-get/submissions/
 */

class MaximumCoins {
    public int maxCoins(int[] piles) {
        //Check validity
        if (piles.length % 3 != 0)
            return -1;

        int result = 0;

        //Create frequency array using constraints
        int[] pilesFrequency = new int[10001];
        for (int pile : piles)
            pilesFrequency[pile]++;

        //Flag is true if Alice made her choice this turn
        boolean flag = false;
        int turnsLeft = (piles.length / 3) * 2;
        int index = pilesFrequency.length - 1;

        //Iterate through the frequency array
        while (turnsLeft > 0) {
            if (pilesFrequency[index] == 0) {
                index--;
                continue;
            }
            pilesFrequency[index]--;
            turnsLeft--;
            if (!flag)
                flag = true;
            else {
                result += index;
                flag = false;
            }
        }

        return result;
    }
}
