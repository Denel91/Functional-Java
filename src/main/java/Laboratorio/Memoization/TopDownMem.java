package Laboratorio.Memoization;

/**
 * Applicala tecnica top-down di memoization alla seguente procedura ricorsiva Java.
 */
public class TopDownMem {

    public static final long UNKNOWN = 0;

    //------------ Versione ricorsiva ------------//

    public static long q(int i, int j, String x) {
        int u = x.length();
        if (i + j < u) {
            return 0;
        } else if (i + j == 0) {
            return 1;
        } else {
            long k = 0;
            if (i > 0) {
                if ((u > 0) && (x.charAt(0) == '0')) {
                    k = k + q(i - 1, j, x.substring(1));
                } else {
                    k = k + q(i - 1, j, x);
                }
            }
            if (j > 0) {
                if ((u > 0) && (x.charAt(0) == '1')) {
                    k = k + q(i, j - 1, x.substring(1));
                } else {
                    k = k + q(i, j - 1, x);
                }
            }
            return k;
        }
    }

    //------------ Memoization ------------//

    private static long qMem(int i, int j, String x, long[][][] h) {
        int u = x.length();
        if (h[i][j][u] == UNKNOWN) {
            if (i + j < u) {
                h[i][j][u] = 0;
            } else if (i + j == 0) {
                h[i][j][u] = 1;
            } else {
                long k = 0;
                if (i > 0) {
                    if ((u > 0) && (x.charAt(0) == '0')) {
                        k = k + qMem(i - 1, j, x.substring(1), h);
                    } else {
                        k = k + qMem(i - 1, j, x, h);
                    }
                }
                if (j > 0) {
                    if ((u > 0) && (x.charAt(0) == '1')) {
                        k = k + qMem(i, j - 1, x.substring(1), h);
                    } else {
                        k = k + qMem(i, j - 1, x, h);
                    }
                }
                h[i][j][u] = k;
            }
        }

        return h[i][j][u];
    }

    public static long qMemoization(int i, int j, String x) {
        int k = x.length();
        long[][][] h = new long[i + 1][j + 1][k + 1];
        for (int u = 0; u <= i; u++) {
            for (int v = 0; v <= j; v++) {
                for (int w = 0; w <= k; w++) {
                    h[u][v][w] = UNKNOWN;
                }
            }
        }

        return qMem(i, j, x, h);
    }
}
