package Laboratorio.Memoization;

/**
 * Length of the longest increasing subsequence
 */
public class LlisMemoization {

    // Variabile di classe
    private static final int UNKNOWN = 0;

    //------------ Versione ricorsiva ------------//

    public static int llis(int[] s) {
        int n = s.length;
        return llisRec(s, n, n, n);
    }

    public static int llisRec(int[] s, int n, int i, int j) {
        if (i == 0) {
            return 0;
        } else if ((j < n) && (s[i - 1] >= s[j])) {
            return llisRec(s, n, i - 1, j);
        } else {
            return Math.max(1 + llisRec(s, n, i - 1, i - 1), llisRec(s, n, i - 1, j));
        }
    }

    //------------ Memoization ------------//

    private static int llisMem(int[] s, int n, int i, int j, int[][] h) {
        if (i == 0) {
            h[i][j] = 0;
        } else if ((j < n) && (s[i - 1] >= s[j])) {
            h[i][j] = llisMem(s, n, i - 1, j, h);
        } else {
            h[i][j] = Math.max(1 + llisMem(s, n, i - 1, i - 1, h), llisMem(s, n, i - 1, j, h));
        }

        return h[i][j];
    }

    public static int llisMemoization(int[] s) {
        int n = s.length;
        final int[][] h = new int[n + 1][n + 1];

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llisMem(s, n, n, n, h);
    }

    public static void main(String[] args) {
        System.out.println("-- Versione ricorsiva --");
        System.out.println(llis(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llis(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3
        System.out.println(llis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})); // 6
        System.out.println("-- Versione memoization --");
        System.out.println(llisMemoization(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llisMemoization(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3
        System.out.println(llisMemoization(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})); // 6
    }
}
