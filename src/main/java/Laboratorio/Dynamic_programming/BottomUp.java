package Laboratorio.Dynamic_programming;

public class BottomUp {
    // Variabile di classe
    private static final int UNKNOWN = 0;

    /**
     * Applica la tecnica Bottom-Up di programmazione dinamica alle seguenti procedure ricorsive.
     */

    //------------ Versione ricorsiva ------------//

    public static long s(int n, int k) { // 1 ≤ k ≤ n
        if (k == n) {
            return 1;
        } else {
            long x = (n - 1) * s(n - 1, k);
            if (k == 1) {
                return x;
            } else {
                return x + s(n - 1, k - 1);
            }
        }
    }

    //------------ Versione Bottom-Up ------------//

    public static long sDP(int n, int k) { // 1 ≤ k ≤ n
        long[][] h = new long[n + 1][k + 1];

        for (int v = 0; v <= k; v++) {
            h[0][v] = 1;
        }

        for (int u = 1; u <= n; u++) {
            h[u][0] = 1;
        }

        for (int u = 1; u <= n; u++) {
            for (int v = 1; v <= k; v++) {
                if (u == v) {
                    h[u][v] = 1;
                } else {
                    long x = (u - 1) * h[u - 1][v];
                    if (v == 1) {
                        h[u][v] = x;
                    } else {
                        h[u][v] = x + h[u - 1][v - 1];
                    }
                }
            }
        }

        return h[n][k];
    }

    //------------ Memoization ------------//

    private static long sMem(int n, int k, long[][] h) {
        if (k == n) {
            h[n][k] = 1;
        } else {
            long x = (n - 1) * sMem(n - 1, k, h);
            if (k == 1) {
                h[n][k] = x;
            } else {
                h[n][k] = x + sMem(n - 1, k - 1, h);
            }
        }

        return h[n][k];
    }

    public static long sMemoization(int n, int k) {
        long[][] h = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                h[i][j] = UNKNOWN;
            }
        }

        return sMem(n, k, h);
    }

    //------------ Versione ricorsiva ------------//

    public static long q(int i, int j, boolean b) {
        if (b) {
            if (i * j == 0) {
                return i + j + 1;
            } else {
                return q(i - 1, j, b) + q(i, j - 1, b) + q(i, j, !b);
            }
        } else {
            if (i * j == 0) {
                return 1;
            } else {
                return q(i - 1, j, b) + q(i, j - 1, b);
            }
        }
    }

    //------------ Prima Versione Bottom-Up ------------//

    public static long qDP(int i, int j, boolean b) {
        long[][][] h = new long[i + 1][j + 1][2];
        for (int v = 0; v <= j; v = v + 1) {
            h[0][v][0] = 1;
            h[0][v][1] = v + 1;
        }
        for (int u = 1; u <= i; u = u + 1) {
            h[u][0][0] = 1;
            h[u][0][1] = u + 1;
        }
        for (int u = 1; u <= i; u = u + 1) {
            for (int v = 1; v <= j; v = v + 1) {
                h[u][v][0] = h[u - 1][v][0] + h[u][v - 1][0];
                h[u][v][1] = h[u - 1][v][1] + h[u][v - 1][1] + h[u][v][0];
            }
        }
        if (b) {
            return h[i][j][1];
        } else {
            return h[i][j][0];
        }
    }

    //------------ Seconda Versione Bottom-Up ------------//

    public static long qBottomUp(int i, int j, boolean b) {
        long[][][] h = new long[i + 1][j + 1][2];

        for (int u = 0; u <= i; u++) {
            for (int v = 0; v <= j; v++) {
                if (u * v == 0) {
                    h[u][v][0] = 1;
                    h[u][v][1] = u + v + 1;
                } else {
                    h[u][v][0] = h[u - 1][v][0] + h[u][v - 1][0];
                    h[u][v][1] = h[u - 1][v][1] + h[u][v - 1][1] + h[u][v][0];
                }
            }
        }

        return h[i][j][b ? 1 : 0];
    }

    //------------ Memoization ------------//

    private static long qMem(int i, int j, boolean b, long[][] h) {
        if (b) {
            if (i * j == 0) {
                h[i][j] = i + j + 1;
            } else {
                h[i][j] = qMem(i - 1, j, b, h) + qMem(i, j - 1, b, h) + qMem(i, j, !b, h);
            }
        } else {
            if (i * j == 0) {
                h[i][j] = 1;
            } else {
                h[i][j] = qMem(i - 1, j, b, h) + qMem(i, j - 1, b, h);
            }
        }

        return h[i][j];
    }

    public static long qMemoization(int i, int j, boolean b) {
        long[][] h = new long[i + 1][j + 1];

        for (int r = 0; r <= i; r++) {
            for (int c = 0; c <= j; c++) {
                h[r][c] = UNKNOWN;
            }
        }

        return qMem(i, j, b, h);
    }

    public static void main(String[] args) {
        System.out.println(s(5, 4)); // 10
        System.out.println(sMemoization(5, 4)); // 10
        System.out.println(sDP(5, 4)); // 10

        System.out.println(q(3, 5, true)); // 504
        System.out.println(qDP(3, 5, true)); // 504
        System.out.println(qBottomUp(3, 5, true)); // 504

        System.out.println(q(6, 7, false)); // 1716
        System.out.println(qDP(6, 7, false)); // 1716

        System.out.println(qMemoization(3, 5, true)); // 504
        System.out.println(qMemoization(6, 7, false)); // 1716
    }
}
