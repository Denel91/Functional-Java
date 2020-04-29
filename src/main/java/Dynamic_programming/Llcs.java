package Dynamic_programming;

/**
 * class Llcs
 *
 * @version 30/04/2020
 */
public class Llcs {
    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static void main(String[] args) {
        System.out.println(llcsMem("to", "to"));
        System.out.println(lcs("sio", "trio"));
        System.out.println(lcsMem("atrio", "arto"));
        System.out.println(lcsBottomUp("arto", "atrio"));
        System.out.println(llcsBottomUp("aromatico", "aromatizzato"));
        System.out.println(llcsMem("aromatico", "aromatizzato"));
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

    /**
     * Procedura di supporto
     *
     * @param u una stringa
     * @param v una stringa
     * @param h un array dove memorizzare i valori
     * @return la lunghezza della sottosequenza comune più lunga
     */
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

    /**
     * Length of longest common subsequence
     * Versione Bottom-Up dynamic programming
     *
     * @param s una stringa
     * @param r una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
    public static int llcsBottomUp(String s, String r) {
        // Compute length of LCS for all sub-problems
        int sl = s.length(), rl = r.length();
        int[][] opt = new int[sl + 1][rl + 1];

        for (int i = sl - 1; i >= 0; i--) {
            for (int j = rl - 1; j >= 0; j--) {
                if (s.charAt(i) == r.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        return opt[0][0];
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
     *
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
     * Procedura di supporto
     *
     * @param u una stringa
     * @param v una stringa
     * @param llcsDb un array dove memorizzare i valori
     * @return sottosequenza comune più lunga
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

    /**
     * Longest common subsequence recurrence
     * Versione Bottom-Up dynamic programming
     *
     * @param s una stringa
     * @param t una stringa
     * @return sottosequenza comune più lunga
     */
    public static String lcsBottomUp(String s, String t) {
        // Compute length of LCS for all sub-problems
        int m = s.length(), n = t.length();
        int[][] opt = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        String lcs = "";
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                lcs += s.charAt(i);
                i++;
                j++;

            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                i++;

            } else {
                j++;
            }
        }

        return lcs;
    }
} // class Llcs
