package CorrectLoop;

import java.util.Arrays;

public class Correctness {

    /**
     * Calcola il quadrato di un numero n
     *
     * @param n il numero di cui calcolare il quadrato
     * @return il quadrato del numero n
     */
    public static int sqr(int n) {  /* PRECONDIZIONE: n >= 0 */
        int x = 0;
        int y = 0;
        int z = 1;

        while (x < n) {             /* INVARIANTE: 0 <= x <= n, y = x^2, z = 2x + 1 */
                                    /* Terminazione: n - x*/
            x = x + 1;
            y = y + z;
            z = z + 2;
        }

        return y;                   /* POSTCONDIZIONE: y = n^2 */
    }

    /*
     * Notazione: Inv(x,y,z)
     *
     * Inv(0,0,1): 0 <= 0 <= n, 0 = 0^2, 1 = 2 * 0 + 1
     * 0 <= n <-- Pre
     *
     * Conservazione:
     * Assumo: Inv(x,y,z) & (x < n)
     * Dimostro: Inv(x+1,y+z,z+2)
     *
     * Inv(x+1,y+z,z+2) : 0 <= x+1 <= n, y+z = (x+1)^2, z+2 = 2(x+1) + 1
     *                    0 <= x+1  <-- 0 <= x
     *                    x+1 <= n  <-- x < n
     *                                   y+z = (x+1)^2 = x^2 + 2x + 1 <-- y = x^2, z = 2x + 1
     *                                                  z+2 = 2(x+1) + 1 = 2x + 1 + 2 <-- z = 2x + 1
     *
     * Risultato finale:
     * Assumo: Inv(x,y,z) & (x >= n)
     * Dimostro: y = n^2
     *
     * x <= n, x >= n --> x = n
     * x = n, y = x^2 --> y = n^2
     *
     * term(x,y,z) = n - x >= 0 <-- x <= n
     * term(x+1,y+z,z+2) = n - (x+1) = n - x -1 < n - x = term(x,y,z) <-- Inv(x,y,z)
     */

    /**
     * Least common multiple
     *
     * @param m un intero > 0
     * @param n un intero > 0
     * @return minimo comune multiplo tra m ed n
     */
    public static int lcm(int m, int n) {   /* Pre m, n > 0 */
        int x = m;
        int y = n;

        while (x != y) {                    /* Inv: 0 < x, y <= mcm(m, n), x mod m = 0, y mod n = 0 */
                                            /* Term: 2 * mcm(m, n)-x-y */
            if (x < y) {

                x = x + m;

            } else { // y < x

                y = y + n;
            }
        }

        return x;                           /* Post: x = mcm(m,n) */
    }

    /**
     * Notazione: Inv(x,y)
     *
     * Inv(m,n): 0 < m, n <= mcm(m, n), m mod m = 0, n mod n = 0
     * Pre
     *
     * Conservazione:
     * Assumo (a): Inv(x,y) & (x < y)
     * Dimostro: Inv(x+m, y)
     *
     * (a): Inv(x+m, y): 0 < x+m, y <= mcm(m, n), (x+m) mod m = 0, y mod n = 0
     * x < y <= mcm(m, n) --> x+m <= mcm(m, n)
     *
     * Assumo (b): Inv(x,y) & (x > y)
     * Dimostro: Inv(x, y+n)
     *
     * Risultato finale:
     * Assumo: Inv(x,y) & (x = y)
     * Dimostro: x = mcm(m, n)
     *
     * 0 < x = y <= mcm(m, n), x mod m = 0, x mod n = 0
     * x mod m = 0, x mod n = 0 --> x >= mcm(m, n)
     * x = mcm(m, n)
     *
     * Terminazione:
     * term(x,y) = 2 * mcm(m, n)-x-y >= 0  <-- x, y <= mcm(m, n)
     * term(x',y') = 2 * mcm(m, n)-x'-y' <= 2 * mcm(m, n)-x-y-min(m,n) < 2 * mcm(m, n)-x-y  <-- m,n > 0
     */

    public static int cube(int n) { /* PRECONDIZIONE: n >= 0 */
                                    /* INVARIANTE: 0 <= x <= n,  y = x^3,  u = 3x^2 + 3x + 1,  v = 6x + 6 */
                                    /* TERMINAZIONE: ?? */
        int x = 0;
        int y = 0;
        int u = 1;
        int v = 6;

        while (x < n) {
            x = x + 1;
            y = y + u;
            u = u + v;
            v = v + 6;
        }

        return y;                   /* POST-CONDIZIONE: y = n^3*/
    }

    public static int[] factorization(int n) {  /* PRE: n >= 2 */
        int[] fattori = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            fattori[i] = 0;
        }

        int x = n;
        int p = 2;

        while (x > 1) {                         /* INVARIANTE: 1 <= x <=n, n = x * Prodotto (k: [2, n]) k^fattori[k] */
                                                /* x non ha fattori < p, 2 <= p <= n */
                                                /* Term: x + n - p */
            if (x % p == 0) {
                fattori[p] = fattori[p] + 1;
                x = x / p;

            } else {
                p = p + 1;
            }
        }

        return fattori;                         /* POST-CONDIZIONE: n = Prodotto (k: [2, n]) k^fattori[k] */
    }

    /**
     * Inv({0,0,0,...,0}, n, 2) : 1 <= n <=n, n = n * Prodotto (k: [2, n]) k^0 = n * 1 = n
     *                            n non ha fattori < 2, 2 <= 2 <= n
     * (a) p divide x
     * ? : 1 <= x/p <= n,
     *     n = x/p * Prodotto (k: [2, p-1]) k^fattori[k] * p^(fattori[p] + 1) * Prodotto (k: [p+1, n]) k^fattori[k]
     *     x/p non ha fattori < p, 2 <= p <= n
     *     n = x * Prodotto (k: [2, p-1]) k^fattori[k] * p^(fattori[p]) * Prodotto (k: [p+1, n]) k^fattori[k]
     *       = x * Prodotto (k: [2, n]) k^fattori[k]
     *
     * (b) ... (prime due asserzioni)
     * x non ha fattori < p+1, 2 <= p+1 <= n
     *
     * Inv(fattori,x,p) & x <= 1  --> x = 1 --> n = 1 * Prodotto (k: [2, n]) k^fattori[k]
     *
     * term: x + n - p >= 0
     *
     * (a) term': x/p + n - p < x + n - p :term
     * (b) term': x + n - (p+1) = (x + n - p) - 1 < x + n - p :term
     */

    /***********************************************************************************************/

    /**
     * Esercizio 4/A della prova scritta del 25 Giugno 2019
     *
     * y = 2q + 1 --> 2 * 0 + 1 --> y = 1
     * y + z = n --> z = n - y --> z = n - 1
     *
     * x + H = (q+1)^2 = q^2 + 2q + 1  --> H = 2q + 1 --> x = x + y
     * y' + z' = n --> y+2 + z-K = n  --> 2 - K = 0 --> K = 2
     *
     * x > z  --> q^2 > z (perchè sono uscito dal while)
     * Quindi z < q^2
     * n = y+z < 2q+1 + q^2 = (q+1)^2
     * n < (q+1)^2  --> sqrt(n) < q+1
     * q^2 <= n  --> q <= sqrt(n) < q+1
     *
     * term: [sqrt(n)] - q --> n - q
     */

    /**
     * Calcola la radice quadrata di n
     *
     * @param n un numero intero di cui calcolare la radice quadrata
     * @return la radice quadrata di n
     */
    public static int intSqrt(int n) {          // Pre: n >= 0
        int q = 0, x = 0, y = 1, z = n - 1;

        while (x <= z) {                        // Inv: 0 ≤ q ≤ √n, x = q^2, y = 2q+1, y+z = n
                                                // Term: n - q
            q = q + 1;
            x = x + y;
            y = y + 2;
            z = z - 2;
        }

        return q;                               // Post: valore restituito:  ⎣√n⎦
    }

    public static void main(String[] args) {
        System.out.println(sqr(5));
        System.out.println(lcm(4, 5));
        System.out.println(Arrays.toString(factorization(6)));
        System.out.println(intSqrt(4));
        System.out.println(intSqrt(9));
        System.out.println(intSqrt(16));
        System.out.println(intSqrt(25));
        System.out.println(intSqrt(36));
    }
} // class Correctness
