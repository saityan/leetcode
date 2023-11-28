package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
 */

public class DivideCorridor {
    private final int MODULO = 1000000007;

    public int numberOfWays(String corridor) {
        // Validity quick check
        if (corridor.length() <= 1)
            return 0;

        List<Integer> seats = new ArrayList<>();

        int nextSeat = corridor.indexOf('S');
        while (nextSeat != -1) {
            seats.add(nextSeat);
            nextSeat = corridor.indexOf('S', nextSeat + 1);
        }

        if (seats.size() == 0 || seats.size() % 2 != 0)
            return 0;
        if (seats.size() == 2)
            return 1;

        long result = 1;
        for (int i = 1; i + 1 < seats.size() - 1; i += 2) {
            int distance = seats.get(i + 1) - seats.get(i);
            if (distance > 1) {
                result = (result * distance) % MODULO;
            }
        }
        return (int) result;
    }
}
