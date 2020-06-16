package Laboratorio.Verifica_Correttezza;

public class VerificaCorrettezza {

    /**
     * Pre: n > 0, ∀ j . x_j ∈ [0, 1],  x_0 = 1
     * Post: k = 2 (∑ {j ∈ [1,n–1]} x_(n–j) * 2^(j–1)) + 1
     *
     * Inv: 0 < i ≤ n, k = 2 (∑ {j ∈ [1,i–1]} x_(i–j) * 2^(j–1)) + 1
     *
     * (1) Inv vale all'inizio del while
     * Inv(1,1): 0 < 1 ≤ n, 1 = 2 (∑ {j ∈ [1,1–1]} x_(1–j) * 2^(j–1)) + 1
     *                      1 = 2 (∑ {j ∈ [1,0]} x_(1–j) * 2^(j–1)) + 1 -> (∑ {j ∈ [1,0]} x_(1–j) * 2^(j–1)) = 0
     *                      1 = 1
     *
     * (3) Se il ciclo while termina e vale Inv allora vale Post
     *
     * Inv(i, k), i >= n
     * Inv: i <= n, i >= n --> i = n
     *
     * Inv(n, k): k = 2 (∑ {j ∈ [1,n–1]} x_(n–j) * 2^(j–1)) + 1 --> k = 2 (∑ {j ∈ [1,i–1]} x_(i–j) * 2^(j–1)) + 1
     *
     * (2) Inv si conserva:
     * Prima del passo iterativo vale Inv(i, k) e inoltre vale i < n
     *
     * 0 < i < n,  k = 2 (∑ {j ∈ [1,i–1]} x_(i–j) * 2^(j–1)) + 1
     *
     * dopo il passo iterativo vale Inv(i', k') -> Inv(i'+1, k')
     *
     * (2a) Se inoltre x_i = 0 -> Inv(i'+1, 2k - 1)
     * Inv(i'+1, 2k - 1): 0 < i+1 ≤ n,  2k - 1 = 2 (∑ {j ∈ [1,i]} x_(i+1–j) * 2^(j–1)) + 1
     *
     *  2 (x_i * 2^0 + (∑ {(j-1) ∈ [1,i-1]} x_(i-(j-1)) * 2^(j–1))) + 1
     *
     *  2 (x_i * 2^0 + (∑ {y ∈ [1,i-1]} x_(i-y)) * 2^y)) + 1
     *
     *  2 (x_i * 2^0 (∑ {y ∈ [1,i-1]} x_(i-y)) * 2^(y)) + 1
     *
     *   2 (0 * 1 (∑ {y ∈ [1,i-1]} x_(i-y)) * 2 * 2^(y-1))) + 1
     *
     *   2 ( 2 ( ∑ {y ∈ [1,i-1]} x_(i-y) * 2^(y-1) ) + 1 ) -1 = 2k - 1
     */
    public static int josephus(String x) {
        final int n = x.length();
        int k = 1;
        int i = 1;

        while (i < n) {
            if (x.charAt(i) == '0') {
                k = 2 * k - 1;
            } else {
                k = 2 * k + 1;
            }

            i = i + 1;
        }

        return k;
    }
}
