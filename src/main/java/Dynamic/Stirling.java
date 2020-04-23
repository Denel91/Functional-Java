package Dynamic;

/**
 * Definizione della classe Stirling per calcolare
 * il numero di Stirling di seconda specie.
 *
 * @version 23/04/2020
 */
public class Stirling {

    /**
     * Il numero di Stirling di seconda specie {n, k} è il numero di modi in cui n oggetti distinguibili possono
     * essere suddivisi tra k sottoinsiemi disgiunti e non vuoti.
     * - Versione ricorsiva
     *
     * @param n an Integer value
     * @param k an Integer value
     * @return an int value
     */
    public static int stirling(int n, int k) {
        if (k == 1 || k == n) {
            return 1;
        } else {
            return stirling(n - 1, k - 1) + (k * stirling(n - 1, k));
        }
    }

    // Variabile di classe
    private static final int UNKNOWN = 0;

    /**
     * Numero di Stirling di seconda specie
     * - Versione memoization
     *
     * @param n an Integer value
     * @param k an Integer value
     * @return an int value
     */
    public static int stirlingMemoization(int n, int k) {
        int[][] h = new int[n + 1][k + 1];
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= k; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return stirlingMem(n, k, h);
    }

    /**
     * Procedura di supporto per calcolare il numero di Stirling di seconda specie
     *
     * @param n an Integer value
     * @param k an Integer value
     * @param h una matrice (array di array) dove vengono salvati i valori man mano calcolati
     * @return an int value
     */
    private static int stirlingMem(int n, int k, int[][] h) {
        if (h[n][k] == UNKNOWN) {
            if (k == 1 || k == n) {
                h[n][k] = 1;
            } else {
                h[n][k] = stirling(n - 1, k - 1) + (k * stirling(n - 1, k));
            }
        }

        return h[n][k];
    }

    public static void main(String[] args) {
        System.out.println(stirling(4, 2)); // 7
        System.out.println(stirlingMemoization(0, 0)); // 1
        System.out.println(stirlingMemoization(5, 3)); // 25
    }
}
