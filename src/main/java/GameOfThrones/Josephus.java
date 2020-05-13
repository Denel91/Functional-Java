package GameOfThrones;

public class Josephus {

    /**
     * Restituisce il cavaliere con la brocca
     *
     * @param n la dimensione di RoundTable
     * @return
     */
    public static int josephus(int n) {
        RoundTable rt = new RoundTable(n);

        while (rt.numberOfKnightsIn() > 1) {
            rt.afterNextKnightQuits();
        }

        return rt.knightWithJugIn();
    }

    public static void main(String[] args) {
        System.out.println(Josephus.josephus(10));
    }
}
