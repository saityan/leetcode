package leetcode.arrays.sorting;

/**
 * leetcode.com/problems/arithmetic-subarrays/
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        //Check validity
        if (nums.length <1 || l.length < 1 || l.length != r.length)
            return Collections.singletonList(false);

        boolean[] result = new boolean[l.length];

        for (int i = 0; i < l.length; i++) {

            //Introduce query
            int first = l[i];
            int last = r[i];
            if (last <= first)
                result[i] = false;
            if (first + 2 > last)
                result[i] = true;

            //Store result of query in array
            int[] localNums = new int[last - first + 1];

            for (int j = first; j <= last; j++)
                localNums[j - first] = nums[j];
            Arrays.sort(localNums);

            int dif = localNums[1] - localNums[0];
            boolean flag = true;
            for (int k = 1; k < localNums.length - 1; k++) {
                if (localNums[k + 1] - localNums[k] != dif) {
                    result[i] = false;
                    flag = false;
                    break;
                }
            }
            if (flag)
                result[i] = true;
        }

        return IntStream.range(0, result.length)
                .mapToObj(i -> result[i])
                .collect(Collectors.toList());
    }
}
