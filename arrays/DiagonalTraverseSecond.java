package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.com/problems/diagonal-traverse-ii/?envType=daily-question&envId=2023-11-22
 *
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the images.
 */

class DiagonalTraverseSecond {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // Create a new list to store diagonal sequences
        List<List<Integer>> diagonalList = new ArrayList<>();

        // Calculate the size of the future result array
        int size = 0;

        // Iterate through the rows of the input matrix
        for (int i = 0; i < nums.size(); i++) {
            // The most important index that helps to store diagonal numbers
            int step = i;

            // Iterate through the elements in the current row
            for (int j = 0; j < nums.get(i).size(); j++) {
                // If the current diagonal list doesn't exist, create it
                if (step == diagonalList.size())
                    diagonalList.add(new ArrayList<>());

                // Add the current element to the appropriate diagonal list
                diagonalList.get(step).add(nums.get(i).get(j));

                // Move to the next diagonal position and increment the size
                step++;
                size++;
            }
        }

        // Create the result array with the calculated size
        int[] result = new int[size];
        int index = 0;

        // Populate the result array (each row goes backwards)
        for (List<Integer> integers : diagonalList) {
            for (int j = integers.size() - 1; j >= 0; j--) {
                result[index] = integers.get(j);
                index++;
            }
        }

        return result;
    }
}
