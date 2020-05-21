package Egyptian_multiplication;

public class Egyptian {

    /**
     * INVARIANTE m, n >= 0
     *
     * @param m un Integer >= 0
     * @param n un Integer >= 0
     * @return il prodotto tra m ed n
     */
    public static int mul(int m, int n) {
        int x = m;
        int y = n;
        int z = 0;

        while (y > 0) {
            // INVARIANTE -> xy + z = mn
            if (y % 2 > 0) {
                z = z + x;
            }

            x = 2 * x;
            y = y / 2;

        }

        return z;
    }

    public static void main(String[] args) {
        System.out.println(mul(83, 13)); // 1079
    }
}
