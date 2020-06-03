package Laboratorio.Simulazione_Esame;

public class llcs {

    // Variabile di classe
    private static final int UNKNOWN = 0;

    /**
     * Lunghezza della sottosequenza comune più lunga
     * (Versione Ricorsiva)
     *
     * @param t una stringa
     * @param u una stringa
     * @param v una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
    public static int llcs3(String t, String u, String v) {
        if (t.equals("") || u.equals("") || v.equals("")) {
            return 0;
        }

        if ((t.charAt(0) == u.charAt(0)) && (u.charAt(0) == v.charAt(0))) {
            return 1 + llcs3(t.substring(1), u.substring(1), v.substring(1));

        } else {
            return Math.max(Math.max(llcs3(t.substring(1), u, v), llcs3(t, u.substring(1), v)), llcs3(t, u, v.substring(1)));
        }
    }

    /**
     * Lunghezza della sottosequenza comune più lunga
     * (Versione che applica la tecnica di memoization)
     *
     * @param t una stringa
     * @param u una stringa
     * @param v una stringa
     * @return la lunghezza della sottosequenza comune più lunga
     */
    public static int llcsMem(String t, String u, String v) {
        int m = t.length();
        int n = u.length();
        int c = v.length();
        int[][][] h = new int[m + 1][n + 1][c + 1];

        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                for (int z = 0; z <= c; z++) {
                    h[x][y][z] = UNKNOWN;
                }
            }
        }

        return llcsRec(t, u, v, h);
    }

    /**
     * Procedura di supporto
     *
     * @param t una stringa
     * @param u una stringa
     * @param v una stringa
     * @param h una matrice dove memorizzare i valori calcolati
     * @return la lunghezza della sottosequenza comune più lunga
     */
    private static int llcsRec(String t, String u, String v, int[][][] h) {
        int m = t.length();
        int n = u.length();
        int c = v.length();

        if (h[m][n][c] == UNKNOWN) {
            if ((m == 0) || (n == 0) || (c == 0)) {
                h[m][n][c] = 0;

            } else if ((t.charAt(0) == u.charAt(0)) && (u.charAt(0) == v.charAt(0))) {
                h[m][n][c] = 1 + llcs3(t.substring(1), u.substring(1), v.substring(1));

            } else {
                h[m][n][c] = Math.max(Math.max(llcs3(t.substring(1), u, v), llcs3(t, u.substring(1), v)), llcs3(t, u, v.substring(1)));
            }
        }

        return h[m][n][c];
    }

    public static void main(String[] args) {
        System.out.println(llcs3("AGCD", "AGCD", "AGCD"));
        System.out.println(llcsMem("AGCD", "AGCD", "AGCD"));
    }
}


