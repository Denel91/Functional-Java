package Laboratorio.Esame;

public class Esercizio1 {
    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        System.out.println(rec(8, 3, 12)); // 20415995028
        System.out.println(recMemoization(8,3,12)); // 20415995028
    }

    //------------ Versione ricorsiva ------------//

    public static long rec(int x, int y, int z) {    // 1 <= x, y <= z
        if ((x > 1) && (y < z)) {
            return rec(x - 1, y, z) + x * rec(x, y + 1, z);
        } else {
            return 1;

        }
    }

    //------------ Memoization ------------//

    private static long recMem(int x, int y, int z, long[][][] h) {
        if (h[x][y][z] == UNKNOWN) {
            if ((x > 1) && (y < z)) {
                h[x][y][z] = recMem(x - 1, y, z, h) + x * recMem(x, y + 1, z, h);

            } else {
                h[x][y][z] = 1;
            }
        }

        return h[x][y][z];
    }

    public static long recMemoization(int x, int y, int z) {
        long[][][] h = new long[x + 1][z + 1][z + 1];

        for (int m = 0; m <= x; m++) {
            for (int n = 0; n <= y; n++) {
                for (int t = 0; t <= z; t++) {
                    h[m][n][t] = UNKNOWN;
                }
            }
        }

        return recMem(x, y, z, h);
    }
}
