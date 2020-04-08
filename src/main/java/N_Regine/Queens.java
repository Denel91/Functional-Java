package N_Regine;

/**
 * Soluzione del rompicapo delle N regine
 *
 * @version 07/04/2020
 */

/*
public class Queens {

    public static int numeroDiSoluzioni(int n) {

        return   numeroDiCompletamenti(new Board(n));
    }


    private static int numeroDiCompletamenti(Board b) {

        int n = b.size();
        int q = b.queensOn();

        if (q == n) {

            return 1;

        } else { // q < n

            int i = q + 1;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    count += numeroDiCompletamenti(b.addQueen(i,j));
                }
            }

            return count;
        }
    }
} // Queens

 */


