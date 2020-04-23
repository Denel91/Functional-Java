package Dynamic;

public class ProgrammazioneDinamica {

    /**
     * Progressione di Fibonacci ricorsiva
     *
     * @param n l'ennesimo elemento della serie
     * @return l'elemento in posizione n
     * * Casi base:
     * * fib(0) = 1
     * * fib(1) = 1
     */
    public static int fib(int n) { // n >= 0
        if (n < 2) {
            return 1;

        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }

    // Variabile di classe
    private static final int UNKNOWN = 0;

    /**
     * Progressione di Fibonacci memoization -> Top-Down
     *
     * @param n l'ennesimo elemento della serie
     * @return l'elemento in posizione n
     */
    public static long fibMem(int n) { // n >= 0
        long[] h = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            h[i] = UNKNOWN;
        }

        return fibRec(n, h);
    }

    /**
     * Procedura di supporto per calcolare la serie di Fibonacci
     *
     * @param n l'ennesimo elemento della serie
     * @param h un array dove vengono salvati i valori man mano calcolati
     * @return l'elemento in posizione n
     */
    private static long fibRec(int n, long[] h) { // n >= 0
        if (h[n] == UNKNOWN) {
            if (n < 2) {
                h[n] = 1;

            } else {
                h[n] = fibRec(n - 2, h) + fibRec(n - 1, h);
            }
        }

        return h[n];
    }

    /**
     * "Percorsi di Manhattan" ricorsivo
     *
     * @param i indice di riga
     * @param j indice di colonna
     * @return il numero possibile di percorsi
     */
    public static long manh(int i, int j) { // i, j >= 0
        if ((i == 0) || (j == 0)) {
            return 1;

        } else {
            return manh(i - 1, j) + manh(i, j - 1);
        }
    }

    /**
     * "Percorsi di Manhattan" memoization -> Top-Down
     *
     * @param i indice di riga
     * @param j indice di colonna
     * @return il numero possibile di percorsi
     */
    public static long manhMem(int i, int j) { // i, j >= 0
        long[][] h = new long[i + 1][i + j];
        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return manhRec(i, j, h);
    }

    /**
     * Procedura di supporto per calcolare i percorsi di Manhattan
     *
     * @param i indice di riga
     * @param j indice di colonna
     * @param h una matrice (array di array) dove vengono salvati i valori man mano calcolati
     * @return il numero possibile di percorsi
     */
    private static long manhRec(int i, int j, long[][] h) { // i, j >= 0
        if (h[i][j] == UNKNOWN) {
            if ((i == 0) || (j == 0)) {
                h[i][j] = 1;

            } else {
                h[i][j] = manhRec(i - 1, j, h) + manhRec(i, j - 1, h);
            }
        }

        return h[i][j];
    }

    /**
     * R(n) = 1 + R(n-2) + R(n-1) per n >= 2
     *
     * R(n) >= (1.5)^(n-1) > 425000000 di ricorsioni per n = 50
     *
     * R(n) >= (1.5)^(n-1) > 2.7 * 10^7 di ricorsioni per n = 100
     * --> 2.7 * 10^8 secondi > 8 anni
     *
     * 1 = R(0) >= (1.5)^-1
     * 1 = R(1) >= (1.5)^0
     * R(n) = 1 + R(n-2) + R(n-1) > (1.5)^n-3 + (1.5)^n-2
     * R(n) >= ((1.5)^-1 + 1) * (1.5)^n-2 > 1.5 (1.5)^n-2
     */

    public static void main(String[] args) {
        System.out.println(fibMem(90));
        System.out.println(manhMem(25, 25));
    }
}
