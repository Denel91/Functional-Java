package Introduction;

public class FirstProgram {
    public static void main(String[] args) {

        System.out.println(supToCil(2.6, 3.4));

        System.out.println(pluraleSM("albero"));

        System.out.println(pluraleSF("primula"));

        System.out.println(femminile("primula"));

        System.out.println(plurale("primula"));

        System.out.println(plurale("torre"));

        System.out.println(b(5));

        System.out.println(b(0));

        System.out.println(btrVal("++"));

        System.out.println(btrVal("+."));

        System.out.println(btrVal("-"));

        System.out.println(btrVal("."));

        System.out.println(btrVal("+"));
    }

    /**
     * @param r: raggio
     * @param h: altezza
     * @return
     */
    public static double supToCil(double r, double h) {

        return (2 * Math.PI * (r + h));
    }

    /**
     * @param s: a string value
     * @return the plural name of a male string
     */
    public static String pluraleSM(String s) {

        return (s.substring(0, s.length() - 1) + "i");
    }

    /**
     * @param s a String value
     * @return the plural name of a female string
     */
    public static String pluraleSF(String s) {

        return (s.substring(0, s.length() - 1) + "e");
    }

    /**
     * @param s a String value
     * @return true if s is female, false otherwise
     */
    public static boolean femminile(String s) {

        return s.charAt(s.length() - 1) == 'a';
    }

    /**
     * @param s a String value
     * @return pluraleSF(s) if s is female, pluraleSM(s) otherwise
     */
    public static String plurale(String s) {

        if (femminile(s)) {

            return pluraleSF(s);

        } else {

            return pluraleSM(s);
        }

        // return (femminile(s) ? pluraleSF(s) : pluraleSM(s));
    }

    // COSTANTI
    private static final double b0 = (100 * Math.pow(2, +0.25));
    private static final double b1 = (100 * Math.pow(2, -0.25));

    public static double b(int k) {
        if (k == 0) {

            return b0;

        } else if (k == 1) {

            return b1;

        } else {

            return (b(k - 2) / 2);
        }
    }

    /**
     * Rappresentazione Ternaria Bilanciata
     *
     * @param num stringa di -/./+
     * @return il valore di btr
     */
    /**
    public static int btrVal(String num) {
        int k = num.length() - 1;
        String pre = num.substring(0, k);
        char lsb = num.charAt(k);

        if (k == 0) {

            return btdVal(lsb);

        } else {

            return (3 * btrVal(pre) + btdVal(lsb));
        }
    }
     */

    /**
     * @param btd il carattere da codificare -/./+
     * @return il valore associato a ciascun carattere
     */
    public static int btdVal(char btd) {
        if (btd == '-') {

            return -1;

        } else if (btd == '.') {

            return 0;

        } else {

            return +1;
        }
    }

    /**
     * Rappresentazione Ternaria Bilanciata
     *
     * @param num una stringa
     * @return il valore di btr
     */
    public static int btrVal(String num) {

        int n = num.length();
        int v = 0;

        for (int i = 0; i < n; i++) {

            v = 3 * v + btdVal(num.charAt(i));
        }

        return v;
    }

    /**
     * @param n an integer value. REQUIRE not null
     * @return an integer value.
     */
    public static int ufo(int n) { // X > 0

        int[] u = new int[n + 1];
        u[1] = 1;

        for (int x = 2; x <= n; x++ ) {

            if ( x % 2 == 0) { // pari

                u[x] = (2 * u[x/2] -1);

            } else { // dispari

                u[x] = (2 * u[x/2] +1);

            }
        }

        return u[n];
    }
}


