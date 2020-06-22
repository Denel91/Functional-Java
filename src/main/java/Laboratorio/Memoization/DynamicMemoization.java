package Laboratorio.Memoization;

public class DynamicMemoization {

    public static final long UNKNOWN = 0;

    //------------ Versione ricorsiva ------------//

    public static long q(int i, int j, int k) { // i, j, k >= 0
        long x = (i < 2) ? i : q(i - 2, j, k);
        long y = (j < 2) ? j : q(i, j - 2, k);
        long z = (k < 2) ? k : q(i, j, k - 2);
        long m = x + y + z;
        return (m == 0) ? 1 : m;
    }

    //------------ Memoization ------------//

    private static long qMem(int i, int j, int k, long[][][] h) { // i, j, k >= 0
        long x = (i < 2) ? i : qMem(i - 2, j, k, h);
        long y = (j < 2) ? j : qMem(i, j - 2, k, h);
        long z = (k < 2) ? k : qMem(i, j, k - 2, h);
        h[i][j][k] = x + y + z;

        if (h[i][j][k] == 0) {
            h[i][j][k] = 1;

        } else {
            return h[i][j][k];
        }

        return h[i][j][k];
    }

    public static long qMemoization(int i, int j, int k) {
        long[][][] h = new long[i + 1][j + 1][k + 1];
        for (int u = 0; u <= i; u++) {
            for (int v = 0; v <= j; v++) {
                for (int w = 0; w <= k; w++) {
                    h[u][v][w] = UNKNOWN;
                }
            }
        }

        return qMem(i, j, k, h);
    }

    public static void main(String[] args) {
        System.out.println("-- Versione ricorsiva --");
        System.out.println(q(0,0,0)); // 1
        System.out.println(q(1,1,1)); // 3
        System.out.println(q(1,3,1)); // 5
        System.out.println(q(3,2,1)); // 8

        System.out.println("-- Memoization --");
        System.out.println(qMemoization(0,0,0)); // 1
        System.out.println(qMemoization(1,1,1)); // 3
        System.out.println(qMemoization(1,3,1)); // 5
        System.out.println(qMemoization(3,2,1)); // 8
    }
}
