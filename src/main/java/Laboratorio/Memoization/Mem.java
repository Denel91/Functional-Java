package Laboratorio.Memoization;

/**
 * Esercizio sulla Memoization
 */
public class Mem {

    public static int q(int[] s) {
        int n = s.length;
        int[] t = new int[n];
        int[][] h = new int[n + 1][n + 1]; // matrice di supporto
        t[0] = s[0];
        for (int k = 1; k < n; k = k + 1) {
            int i = k - 1;
            while ((i >= 0) && (t[i] > s[k])) {
                t[i + 1] = t[i];
                i = i - 1;
            }

            t[i + 1] = s[k];
        }
        return qMem(s, t, n, 0, 0, h);
    }

    //------------ Versione ricorsiva ------------//

    /**
     * Versione con la tecnica della ricorsione
     */
    private static int qRec(int[] s, int[] t, int n, int i, int j) {
        if ((i == n) || (j == n)) {
            return 0;
        } else if (s[i] == t[j]) {
            return 1 + qRec(s, t, n, i + 1, j + 1);
        } else {
            return Math.max(qRec(s, t, n, i + 1, j), qRec(s, t, n, i, j + 1));
        }
    }

    //------------ Memoization ------------//

    /**
     * Versione con la tecnica della memoization
     */
    private static int qMem(int[] s, int[] t, int n, int i, int j, int[][] h) {
        if ((i == n) || (j == n)) {
            h[i][j] = 0;
        } else if (s[i] == t[j]) {
            h[i][j] = 1 + qRec(s, t, n, i + 1, j + 1);
        } else {
            h[i][j] = Math.max(qRec(s, t, n, i + 1, j), qRec(s, t, n, i, j + 1));
        }

        return h[i][j];
    }

    public static void main(String[] args) {
        System.out.println(q(new int[]{2, 5, 7, 8, 3})); // 4
        System.out.println(q(new int[]{2, 5, 7, 8, 3})); // 4
    }
}
