package Dynamic;

/**
 * Definizione della classe ProgrammazioneDinamica
 *
 * @version 28/04/2020
 */
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
     * "Percorsi di Manhattan"
     * Bottom-Up --> Programmazione Dinamica
     *
     * @param i indice di riga
     * @param j indice di colonna
     * @return il numero possibile di percorsi
     */
    public static long manhDP(int i, int j) { // i, j >= 0
        long[][] h = new long[i + 1][i + j];
        for (int y = 0; y <= j; y++) {
            h[0][y] = 1;
        }

        for (int x = 1; x <= i; x++) {
            h[x][0] = 1;
        }

        for (int x = 1; x <= i; x++) {
            for (int y = 1; y <= j; y++) {
                h[x][y] = h[x - 1][y] + h[x][y - 1];
            }
        }

        return h[i][j];
    }

    // Versione alternativa

    /**
     * "Percorsi di Manhattan"
     * Bottom-Up --> Programmazione Dinamica
     *
     * @param i indice di riga
     * @param j indice di colonna
     * @return il numero possibile di percorsi
     */
    public static long manhDp(int i, int j) {
        long[][] h = new long[i + 1][i + j];
        for (int y = 0; y <= j; y++) {
            h[0][y] = 1;
        }

        for (int x = 1; x <= i; x++) {
            h[x][0] = 1;
        }

        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                if (x == 0 || y == 0) {
                    h[x][y] = 1;
                } else {
                    h[x][y] = h[x - 1][y] + h[x][y - 1];
                }
            }
        }

        return h[i][j];
    }

    public static void main(String[] args) {
        System.out.println(fibMem(90));
        System.out.println(manhMem(25, 25));
        System.out.println(manhDP(4, 5));
        System.out.println(manhDp(4, 5));
    }
}
