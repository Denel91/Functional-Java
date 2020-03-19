package Introduction;

/**
 * Massimo Comune Divisore
 */
public class MCD {
    public static void main(String[] args) {

        System.out.println(gcd(18, 24));

        System.out.println(lcm(2,2));
    }

    // Greatest Common Divisor – Massimo Comun Divisore
    /**
    public static int gcd(int x, int y) { // x, y > 0

        if (x < y) {

            return gcd(x, y - x);

        } else if (x > y) {

            return gcd(x - y, y);
        } else {

            return x;
        }
    }*/

    // Greatest Common Divisor – Massimo Comun Divisore
    public static int gcd(int x, int y) { // x, y > 0

        while (x != y) {
            if (x < y) {
                y = y - x;
            } else {
                x = x - y;
            }
        }

        return x;
    }

    // minimo comune multiplo
    public static int lcm(int x, int y) {

        int m = x;
        while ( m % y != 0) {

            m = m + x;
        }

        return m;
    }
}
