package Laboratorio.Length_longest_increasing_subsequence;

import Liste.IntSList;

import java.util.Arrays;

/**
 * class length of the longest increasing subsequence
 *
 * @version 05/05/2020
 */
public class Llis {

    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        // Calcola la lunghezza della più lunga sottosequenza di s strettamente crescente (Versione Ricorsiva)
        System.out.println("Versione ricorsiva: ");
        System.out.println(llis(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llis(new int[]{3, 10, 2, 1, 20})); // 3
        System.out.println(llis(new int[]{7, 38, 39, 25, 44})); // 4
        System.out.println(llis(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // 4
        System.out.println(llis(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llis(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3

        // Calcola la lunghezza della più lunga sottosequenza di s strettamente crescente (Versione Memoization)
        System.out.println("Versione memoization: ");
        System.out.println(llisMemoization(new int[]{3, 10, 2, 1, 20})); // 3

        /*
        System.out.println(llisMemoization(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llisMemoization(new int[]{47, 38, 39, 25, 44})); // 3
        System.out.println(llisMemoization(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // 4
        System.out.println(llisMemoization(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llisMemoization(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3
        System.out.println(llisMemoization(new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(llisMemoization(new int[]{5, 4, 8})); // 2
        System.out.println(llisMemoization(new int[]{50, 3, 10, 7, 40, 80})); // 4
        System.out.println(llisMemoization(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})); // 6
         */
    }

    /**
     * Length of the longest increasing subsequence
     * (recursive)
     *
     * @param s an array of Integers
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    public static int llis(int[] s) {
        return llisRec(s, 0, 0);
    }

    /**
     * Length of the longest increasing subsequence
     * Versione ricorsiva
     *
     * @param s an array of Integers
     * @param i an index
     * @param t an index
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    private static int llisRec(int[] s, int i, int t) {
        final int n = s.length;
        if (i == n) {
            return 0;

        } else if (s[i] <= t) {
            return llisRec(s, i + 1, t);

        } else {
            return Math.max(1 + llisRec(s, i + 1, s[i]), llisRec(s, i + 1, t));
        }
    }

    /**
     * Length of the longest increasing subsequence
     * (memoization)
     *
     * @param s an array of Integers
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    public static int llisMemoization(int[] s) {
        final int n = s.length;
        final int[][] h = new int[n + 1][n + 1];
        int[] b = Arrays.copyOf(s, n + 1); // b: {3, 10, 2, 1, 20, 0} -> ultima posizione 0

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llisMem(b, 0, 0, h);
    }

    /**
     * Length of the longest increasing subsequence
     * Versione memoization
     *
     * @param s an array of Integers
     * @param i an index
     * @param j an index
     * @param h an array to store the values
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    private static int llisMem(int[] s, int i, int j, int[][] h) { // s: {3, 10, 2, 1, 20, 0}
        final int n = s.length; // 6

        int t = s[j];

        if (i == n) {
            h[i][j] = 0;

        } else if (s[i] <= t) {
            h[i][j] = llisMem(s, i + 1, s[j], h);

        } else {
            h[i][j] = Math.max(1 + llisMem(s, i + 1, i, h), llisMem(s, i + 1, j, h));

        }

        return h[i][j];
    }

    /**
     * Longest increasing subsequence
     * Versione memoization
     *
     * @param s
     * @return
     */
    public static IntSList lis(int[] s) {
        final int n = s.length;
        final IntSList[][] h = new IntSList[n + 1][n + 1];

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = IntSList.NULL_INTLIST;
            }
        }

        return lisMem(s, 0, 0, h);
    }

    /**
     * Procedura di supporto per longest increasing subsequence
     * Versione memoization
     *
     * @param s
     * @param i
     * @param j
     * @param h
     * @return
     */
    private static IntSList lisMem(int[] s, int i, int j, IntSList[][] h) {
        // s: {3, 10, 2, 1, 20} i: 0 t: 0 list: (-)
        final int n = s.length; // n = 5
        int[] p = new int[n + 1];

        int t = p[j];

        if (i == n) {
            h[i][j] = IntSList.NULL_INTLIST;

        } else if (s[i] <= t) {
            h[i][j] = lisMem(s, i + 1, t, h);

        } else {
            h[i][j] = longer(lisMem(s, i + 1, s[i], h).cons(s[i]), lisMem(s, i + 1, t, h));

        }

        return h[i][j];
    }

    private static IntSList longer(IntSList a, IntSList b) {
        int m = a.length();
        int n = b.length();

        if (m < n) {
            return b;

        } else if (m > n) {
            return a;

        } else if (Math.random() < 0.5) {
            return b;

        } else {
            return a;
        }
    }
}

