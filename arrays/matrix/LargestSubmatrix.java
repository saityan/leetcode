package leetcode.arrays.matrix;

import java.util.Arrays;
import java.util.Collections;

/**
 * leetcode.com/problems/largest-submatrix-with-rearrangements/
 */

class LargestSubmatrix {
    public int largestSubmatrix(int[][] matrix) {
        int height = matrix.length;
        if (height < 1)
            return -1;
        int width = matrix[0].length;
        if (width < 1)
            return -1;

        int result = 0;

        //Create and populate frequency map
        int[][] frequencyMap = new int[height][width];
        for (int i = 0; i < height; i++) {
            if (i > 0 && i == (height - 1)) {
                for (int j = 0; j < width; j++)
                    if (matrix[i][j] != 0)
                        frequencyMap[i][j] = 1;
            } else
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] != 0) {
                        frequencyMap[i][j] = 1;
                        if (i != 0 && frequencyMap[i - 1][j] > 1) {
                            frequencyMap[i][j] = frequencyMap[i - 1][j] - 1;
                        } else {
                            int k = i;
                            while (k + 1 < height) {
                                if (matrix[k + 1][j] != 0) {
                                    frequencyMap[i][j]++;
                                    k++;
                                } else
                                    break;
                            }
                        }
                    }
                }
        }

        //Iterate through the map
        for (int i = 0; i < height; i++) {

            //Sort current row
            int[] localRow = Arrays.stream(frequencyMap[i]).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

            for (int j = 0; j < width; j++) {
                if (localRow[j] == 0)
                    break;
                result = Math.max(localRow[j] * (j + 1), result);
            }
        }
        return result;
    }
}
