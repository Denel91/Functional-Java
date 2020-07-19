package Laboratorio.Dynamic_programming;

/**
 * Applica la tecnica Bottom-Up di programmazione dinamica alla seguente procedura
 * ricorsiva, al fine di trasformarla in un programma iterativo più efficiente.
 */
public class DynamicBottomUp {
    // Variabile di classe
    private static final int UNKNOWN = 0;

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

    //------------ Versione Bottom-Up ------------//

    // Non va...da rivedere! //
    public static long qBottomUp(int i, int j, String t) {
        int u = t.length();
        long[][][] h = new long[i + 1][j + 1][u + 1];

        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                for (int z = 0; z <= u; z++) {
                    if (x + y < u - z) {
                        h[x][y][z] = 0;
                    } else if (x + y == 0) {
                        h[x][y][z] = 1;
                    }
                }
            }
        }

        for (int x = 1; x <= i; x++) {
            for (int y = 1; y <= j; y++) {
                for (int z = u; z >= 0; z--) {
                    long k = 0;
                    if (x > 0) {
                        if ((u - z > 0) && (t.charAt(z) == '0')) {
                            k = k + h[x - 1][y][z + 1];
                        } else {
                            k = k + h[x - 1][y][z];
                        }
                    }
                    if (y > 0) {
                        if ((u - z > 0) && (t.charAt(z) == '1')) {
                            k = k + h[x][y - 1][z + 1];
                        } else {
                            k = k + h[x][y - 1][z];
                        }
                    }

                    h[x][y][z] = k;
                }
            }
        }

        return h[i][j][u];
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
        int u = x.length();
        long[][][] h = new long[i + 1][j + 1][u + 1];

        for (int k = 0; k <= i; k++) {
            for (int y = 0; y <= j; y++) {
                for (int z = 0; z <= u; z++) {
                    h[k][y][z] = UNKNOWN;
                }
            }
        }

        return qMem(i, j, x, h);
    }

    public static void main(String[] args) {
        System.out.println(q(5, 8, "1010")); // 1246
        System.out.println(qMemoization(5, 8, "1010")); // 1246
        System.out.println(qBottomUp(5, 8, "1010"));
    }
}
