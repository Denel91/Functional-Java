package Laboratorio.Memoization;

public class Memoization {

    // Variabile di classe
    private static final String[] UNKNOWN = null;

    /**
     * Versione ricorsiva
     *
     * @param u una stringa
     * @param v una stringa
     * @return la differenza tra le due stringhe
     */
    public static String[] diff(String u, String v) {
        if (u.equals("") || v.equals("")) {
            return new String[]{u, v};

        } else if (u.charAt(0) == v.charAt(0)) {
            return diff(u.substring(1), v.substring(1));

        } else {
            String[] x = diff(u.substring(1), v);
            String[] y = diff(u, v.substring(1));

            if (x[0].length() < y[0].length()) {
                return new String[]{u.charAt(0) + x[0], x[1]};
            } else {
                return new String[]{y[0], v.charAt(0) + y[1]};
            }
        }
    }

    //------------ Memoization ------------//

    /**
     * Versione con la tecnica della memoization
     *
     * @param u una stringa
     * @param v una stringa
     * @return la differenza tra le due stringhe
     */
    public static String[] diffMem(String u, String v) {
        int m = u.length();
        int n = v.length();
        String[][][] h = new String[m + 1][n + 1][];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                h[i][j] = UNKNOWN;
            }
        }

        return diffRec(u, v, h);
    }

    private static String[] diffRec(String u, String v, String[][][] h) {
        int i = u.length();
        int j = v.length();

        if (h[i][j] == UNKNOWN) {

            if (u.equals("") || v.equals("")) {
                h[i][j] = new String[]{u, v};

            } else if (u.charAt(0) == v.charAt(0)) {
                h[i][j] = diffRec(u.substring(1), v.substring(1), h);

            } else {
                String[] x = diffRec(u.substring(1), v, h);
                String[] y = diffRec(u, v.substring(1), h);

                if (x[0].length() < y[0].length()) {
                    h[i][j] = new String[]{u.charAt(0) + x[0], x[1]};
                } else {
                    h[i][j] = new String[]{y[0], v.charAt(0) + y[1]};
                }
            }
        }

        return h[i][j];
    }

    public static void display(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "\t");
        }
    }

    public static void main(String[] args) {
        display(diff("arto", "atrio")); // r  ri
        System.out.println();
        display(diffMem("arto", "atrio")); // r  ri
    }
} // class Memoization
