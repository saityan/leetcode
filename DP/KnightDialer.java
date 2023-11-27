package leetcode.DP;

/**
 * leetcode.com/problems/knight-dialer/
 */

class KnightDialer {
    private static final int MODULO = 1000000007;

    //Check degenerate case
    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        //Implement Adjacency Matrix and base vector
        long[][] adjMatrix = {
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}
        };

        long[][] baseVector = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        //Iterate through the k = n - 1 numbers
        int k = n - 1;
        while (k > 0) {
            if ((k & 1) != 0) {
                baseVector = multiply(baseVector, adjMatrix);
            }

            adjMatrix = multiply(adjMatrix, adjMatrix);
            k = k / 2;
        }

        int result = 0;
        for (long i : baseVector[0]) {
            result = (int) ((result + i) % MODULO);
        }

        return result;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;

        long[][] result = new long[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MODULO;
                }
            }
        }

        return result;
    }
}
