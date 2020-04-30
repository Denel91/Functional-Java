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
        System.out.println(llcsBottomUp("arto", "atrio")); // 3
        System.out.println(lcsBottomUp("atrio", "arto")); // aro

        System.out.println(llcsDP("arto", "atrio")); // 3
        System.out.println(lcsDP("arto", "atrio")); // aro

        // Calcola la lunghezza della sottosequenza comune più lunga fra tre stringhe
        System.out.println(llcsBotUp("CCGG", "CCGDDEE", "CCGCG")); // 3
        // Calcola sottosequenza comune più lunga fra tre stringhe
        System.out.println(lcsBotUp("CCGG", "CCGDDEE", "CCGCG")); // CCG

        System.out.println(llcsBotUp("DDEECCGG", "DDEECG", "DEEEE")); // 3
        System.out.println(lcsBotUp("DDEECCGG", "DDEECG", "DEEEE")); // DEE
    }

    //--------- Lunghezza della sottosequenza comune più lunga (LLCS) ---------//

    /**
     * Lunghezza della sottosequenza comune più lunga
     *
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

    /**
     * Versione che applica la tecnica di memoization
     *
     * @param u una stringa
     * @param v una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
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
     * Versione Bottom-Up dynamic programming (Prima Versione)
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
                if ((i == sl) || (j == rl)) {
                    opt[i][j] = 0;

                } else if (s.charAt(i) == r.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;

                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        return opt[0][0];
    }

    /**
     * Versione Bottom-Up dynamic programming (Seconda Versione)
     *
     * @param u una stringa
     * @param v una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
    public static int llcsDP(String u, String v) {
        int m = u.length(), n = v.length();
        int[][] h = new int[m + 1][n + 1];

        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                if ((x == 0) || (y == 0)) {
                    h[x][y] = 0;
                } else if (u.charAt(m - x) == v.charAt(n - y)) {
                    h[x][y] = 1 + h[x - 1][y - 1];
                } else {
                    h[x][y] = Math.max(h[x - 1][y], h[x][y - 1]);
                }
            }
        }

        return h[m][n];
    }

    /**
     * Length of longest common subsequence of three strings
     * Versione Bottom-Up dynamic programming
     *
     * @param u una stringa
     * @param v una stringa
     * @param z una stringa
     * @return la lunghezza della sottosequenza comune più lunga tra le tre stringhe
     */
    public static int llcsBotUp(String u, String v, String z) {
        int m = u.length(), n = v.length(), l = z.length();
        int[][][] btup = new int[m + 1][n + 1][l + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = l - 1; k >= 0; k--) {
                    if (i == m || j == n || k == l) {
                        btup[i][j][k] = 0;

                    } else if (u.charAt(i) == v.charAt(j) && v.charAt(j) == z.charAt(k)) {
                        btup[i][j][k] = btup[i + 1][j + 1][k + 1] + 1;

                    } else {
                        btup[i][j][k] = Math.max(Math.max(btup[i + 1][j][k], btup[i][j + 1][k]), btup[i][j][k + 1]);
                    }
                }
            }
        }

        return btup[0][0][0];
    }

    //--------- Sottosequenza comune più lunga (LCS) --------- //

    /**
     * Sottosequenza comune più lunga
     *
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

    /**
     * Versione che applica la tecnica di memoization
     *
     * @param u una stringa
     * @param v una stringa
     * @return sottosequenza comune più lunga
     */
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
     * @param u      una stringa
     * @param v      una stringa
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
     * Versione Bottom-Up dynamic programming (Prima Versione)
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
                if (i == m || j == n) {
                    opt[i][j] = 0;

                } else if (s.charAt(i) == t.charAt(j)) {
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

            } else if (opt[i + 1][j] > opt[i][j + 1]) {
                i++;

            } else if (opt[i + 1][j] < opt[i][j + 1]) {
                j++;

            } else if (Math.random() < 0.5) {
                j++;

            } else {
                i++;
            }
        }

        return lcs;
    }

    /**
     * Versione Bottom-Up dynamic programming (Seconda Versione)
     *
     * @param u una stringa
     * @param v una stringa
     * @return sottosequenza comune più lunga
     */
    public static String lcsDP(String u, String v) {
        int m = u.length(), n = v.length();
        int[][] h = new int[m + 1][n + 1];

        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                if ((x == 0) || (y == 0)) {
                    h[x][y] = 0;

                } else if (u.charAt(m - x) == v.charAt(n - y)) {
                    h[x][y] = 1 + h[x - 1][y - 1];

                } else {
                    h[x][y] = Math.max(h[x - 1][y], h[x][y - 1]);
                }
            }
        }

        String lcs = "";
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (u.charAt(m - i) == v.charAt(n - j)) {
                lcs += u.charAt(m - i);
                i--;
                j--;

            } else if (h[i - 1][j] > h[i][j - 1]) {
                i--;

            } else if (h[i - 1][j] < h[i][j - 1]) {
                j--;

            } else if (Math.random() < 0.5) {
                j--;

            } else {
                i--;
            }
        }

        return lcs;
    }

    /**
     * Longest common subsequence recurrence of three strings
     * Versione Bottom-Up dynamic programming
     *
     * @param u una stringa
     * @param v una stringa
     * @param z una stringa
     * @return sottosequenza comune più lunga
     */
    public static String lcsBotUp(String u, String v, String z) {
        int m = u.length(), n = v.length(), l = z.length();
        int[][][] btup = new int[m + 1][n + 1][l + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = l - 1; k >= 0; k--) {
                    if (i == m || j == n || k == l) {
                        btup[i][j][k] = 0;

                    } else if (u.charAt(i) == v.charAt(j) && v.charAt(j) == z.charAt(k)) {
                        btup[i][j][k] = btup[i + 1][j + 1][k + 1] + 1;

                    } else {
                        btup[i][j][k] = Math.max(Math.max(btup[i + 1][j][k], btup[i][j + 1][k]), btup[i][j][k + 1]);
                    }
                }
            }
        }

        String lcs = "";
        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k < l) {
            if (u.charAt(i) == v.charAt(j) && v.charAt(j) == z.charAt(k)) {
                lcs += u.charAt(i);
                i++;
                j++;
                k++;

            } else if (btup[i + 1][j][k] > btup[i][j + 1][k] && btup[i + 1][j][k] > btup[i][j][k + 1]) {
                i++;

            } else if (btup[i + 1][j][k] < btup[i][j + 1][k] && btup[i + 1][j][k] < btup[i][j][k + 1]) {
                j++;
                k++;

            } else if (Math.random() < 0.5) {
                j++;
                k++;

            } else {
                i++;
            }
        }

        return lcs;
    }
} // class Llcs
