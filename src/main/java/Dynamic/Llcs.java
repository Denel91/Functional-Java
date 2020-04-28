package Dynamic;

/**
 * class Llcs
 *
 * @version 28/04/2020
 */
public class Llcs {
    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        System.out.println(llcsMem("to", "to"));
        System.out.println(lcs("sio", "trio"));
        System.out.println(lcsMem("atrio", "arto"));
    }

    //--------- Lunghezza della sottosequenza comune più lunga (LLCS) ---------//

    /**
     * @param u una stringa
     * @param v una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
    public static int llcs(String u, String v) {
        int m = u.length();
        int n = v.length();

        if ((m == 0) || (n == 0)) {
            return 0;

        } else if (u.charAt(0) == v.charAt(0)) {
            return 1 + llcs(u.substring(1), v.substring(1));

        } else {
            return Math.max(llcs(u.substring(1), v), llcs(u, v.substring(1)));
        }
    }

    // Versione che applica la tecnica di memoization:
    public static int llcsMem(String u, String v) {
        int m = u.length();
        int n = v.length();

        int[][] h = new int[m + 1][n + 1];
        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llcsRec(u, v, h);
    }

    private static int llcsRec(String u, String v, int[][] h) {
        int m = u.length();
        int n = v.length();

        if (h[m][n] == UNKNOWN) {

            if ((m == 0) || (n == 0)) {
                h[m][n] = 0;

            } else if (u.charAt(0) == v.charAt(0)) {
                h[m][n] = 1 + llcs(u.substring(1), v.substring(1));

            } else {
                h[m][n] = Math.max(llcs(u.substring(1), v), llcs(u, v.substring(1)));
            }
        }

        return h[m][n];
    }

    //--------- Sottosequenza comune più lunga (LCS) --------- //

    /**
     * @param u una stringa
     * @param v una stringa
     * @return sottosequenza comune più lunga
     */
    public static String lcs(String u, String v) {
        if (u.equals("") || v.equals("")) {
            return "";

        } else if (u.charAt(0) == v.charAt(0)) {
            return u.charAt(0) + lcs(u.substring(1), v.substring(1));

        } else {
            return longer(lcs(u.substring(1), v), lcs(u, v.substring(1)));
        }
    }

    /**
     * Procedura di supporto
     * @param u una stringa
     * @param v una stringa
     * @return la stringa più lunga tra u e v
     */
    private static String longer(String u, String v) {
        int m = u.length();
        int n = v.length();

        if (m < n) {
            return v;

        } else if (m > n) {
            return u;

        } else if (Math.random() < 0.5) {
            return v;

        } else {
            return u;
        }
    }

    // Versione che applica la tecnica di memoization:
    public static String lcsMem(String u, String v) {
        int m = u.length();
        int n = v.length();
        String[][] llcsDb = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                llcsDb[i][j] = null;
            }
        }

        return lcsRec(u, v, llcsDb);
    }

    /**
     * Procedura privata di supporto
     */
    private static String lcsRec(String u, String v, String[][] llcsDb) {
        int i = u.length();
        int j = v.length();

        if (llcsDb[i][j] == null) {

            if (u.equals("") || v.equals("")) {
                llcsDb[i][j] = "";

            } else if (u.charAt(0) == v.charAt(0)) {
                llcsDb[i][j] = u.charAt(0) + lcsRec(u.substring(1), v.substring(1), llcsDb);

            } else {
                llcsDb[i][j] = longer(lcsRec(u.substring(1), v, llcsDb), lcsRec(u, v.substring(1), llcsDb));
            }
        }

        return llcsDb[i][j];
    }
} // class Llcs
