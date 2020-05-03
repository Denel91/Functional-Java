package Laboratorio.Length_longest_increasing_subsequence;

/**
 * class length of the longest increasing subsequence
 */
public class Llis {

    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        // Calcola la lunghezza della più lunga sottosequenza di s strettamente crescente
        System.out.println(llis(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llisMemoization(new int[]{5, 4, 3, 2, 1})); // 1
        System.out.println(llisMemoization(new int[]{47, 38, 39, 25, 44})); // 3
        System.out.println(llisMemoization(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); // 4
        System.out.println(llisMemoization(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); // 5
        System.out.println(llisMemoization(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); // 3
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
        final int[] h = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            h[i] = UNKNOWN;
        }

        return llisMem(s, 0, 0, h);
    }

    /**
     * Length of the longest increasing subsequence
     * Versione memoization
     *
     * @param s an array of Integers
     * @param i an index
     * @param t an index
     * @param h an array to store the values
     * @return la lunghezza della più lunga sottosequenza di s strettamente crescente
     */
    private static int llisMem(int[] s, int i, int t, int[] h) {
        final int n = s.length;
        if (i == n) {
            h[i] = 0;

        } else if (s[i] <= t) {
            h[i] = llisRec(s, i + 1, t);

        } else {
            h[i] = Math.max(1 + llisRec(s, i + 1, s[i]), llisRec(s, i + 1, t));
        }

        return h[i];
    }
}
