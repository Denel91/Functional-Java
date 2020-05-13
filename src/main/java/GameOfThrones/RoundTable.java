package GameOfThrones;

/**
 * RoundTable t = new RoundTable();
 * t.numberOfKnightsIn() : int
 * t.knightWithJugIn() : int
 * t.afterNextKnightQuits();
 */
public class RoundTable {
    private int[] knights;    // array dei cavalieri (numerati)
    private int num;          // numero dei cavalieri
    private int jug;          // cavaliere con la brocca

    public RoundTable(int n) {
        knights = new int[2 * n - 1];
        for (int k = 1; k <= n; k++) {
            knights[k - 1] = k;
        }
        num = n;
        jug = 0;
    }

    /**
     * Calcola la dimensione della TavolaRotonda
     *
     * @return la dimensione della TavolaRotonda
     */
    public int numberOfKnightsIn() {
        return num;
    }

    /**
     * Calcola il cavaliere con la brocca
     *
     * @return un numero intero
     */
    public int knightWithJugIn() {
        return knights[jug];
    }

    public void afterNextKnightQuits() {
        knights[jug + num] = knights[jug];
        jug = jug + 2;
        num = num - 1;
    }
}
