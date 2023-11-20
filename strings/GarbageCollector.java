package leetcode.strings;

import java.util.Arrays;

/**
 * leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 *
 * Return the minimum number of minutes needed to pick up all the garbage.
 */

class GarbageCollector {
    public int garbageCollection(String[] garbage, int[] travel) {
        // Check the data
        if (garbage.length < 1 || travel.length + 1 != garbage.length) {
            return -1;
        }

        // Constants for truck types
        final int METAL_TRUCK = 0;
        final int GLASS_TRUCK = 1;
        final int PAPER_TRUCK = 2;

        int[] localTimes = new int[garbage.length];
        localTimes[0] = 0;

        // Calculate local times
        for (int i = 1; i < localTimes.length; i++) {
            localTimes[i] = localTimes[i - 1] + travel[i - 1];
        }

        int[] timeTraveled = new int[3];
        int[] timeSpent = new int[3];

        // Iterate through garbage and update corresponding time values
        for (int i = 0; i < garbage.length; i++) {
            char[] currentGarbage = garbage[i].toCharArray();
            for (char currentChar : currentGarbage) {
                if (currentChar == 'M') {
                    timeTraveled[METAL_TRUCK] = localTimes[i];
                    timeSpent[METAL_TRUCK]++;
                } else if (currentChar == 'G') {
                    timeTraveled[GLASS_TRUCK] = localTimes[i];
                    timeSpent[GLASS_TRUCK]++;
                } else if (currentChar == 'P') {
                    timeTraveled[PAPER_TRUCK] = localTimes[i];
                    timeSpent[PAPER_TRUCK]++;
                }
            }
        }

        // Return sum of both arrays (time spent traveling and time spent collecting)
        return Arrays.stream(timeTraveled).sum() + Arrays.stream(timeSpent).sum();
    }
}
