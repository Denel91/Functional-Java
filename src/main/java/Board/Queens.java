package Board;

/**
 * Soluzione del rompicapo delle N regine
 *
 * Class overview:
 * numeroDiSoluzioni(int n) : int
 * numeroDiCompletamenti(Board b) : int
 *
 * @version 07/05/2020
 */
public class Queens {

    public static int numeroDiSoluzioni(int n) {
        return numeroDiCompletamenti(new Board(n));
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
                    b.addQueen(i, j);
                    count += numeroDiCompletamenti(b);
                    b.removeQueen(i, j);
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(Queens.numeroDiSoluzioni(1)); // 1
        System.out.println(Queens.numeroDiSoluzioni(2)); // 0
        System.out.println(Queens.numeroDiSoluzioni(3)); // 0
        System.out.println(Queens.numeroDiSoluzioni(4)); // 2
        System.out.println(Queens.numeroDiSoluzioni(5)); // 10
        System.out.println(Queens.numeroDiSoluzioni(6)); // 4
        System.out.println(Queens.numeroDiSoluzioni(7)); // 40
        System.out.println(Queens.numeroDiSoluzioni(8)); // 92
        System.out.println(Queens.numeroDiSoluzioni(9)); // 352
        System.out.println(Queens.numeroDiSoluzioni(10)); // 724
    }
}
