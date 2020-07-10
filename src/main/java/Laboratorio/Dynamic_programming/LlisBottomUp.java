package Laboratorio.Dynamic_programming;

import java.util.Vector;

public class LlisBottomUp {
    // Variabile di classe
    private static final int UNKNOWN = 0;

    public static int llis(Vector<Integer> s) {
        return llisRec(s, 0, 0);
    }

    //------------ Versione ricorsiva ------------//

    public static int llisRec(Vector<Integer> s, int t, int k) {
        if (k == s.size()) {
            return 0;
        } else if (s.get(k) <= t) {
            return llisRec(s, t, k + 1);
        } else {
            return Math.max(1 + llisRec(s, s.get(k), k + 1), llisRec(s, t, k + 1));
        }
    }

    //------------ Versione Bottom-Up ------------//

    public static int llisDP(Vector<Integer> s, int t, int k) {
        Vector<Integer> b = new Vector<>(s.size() + 1);

        for (int i = 0; i < s.size(); i++) {
            b.add(s.get(i));
        }

        b.add(0); // b -> [3, 10, 2, 1, 20, 0]

        int[][] h = new int[b.size() + 1][b.size() + 1];

        for (int x = 0; x <= t; x++) {
            h[x][b.size()] = 0;
        }

        for (int y = 0; y <= k; y++) {
            h[b.size()][y] = 0;
        }


        /**
         *
         * Matrice h riempita con i casi base.
         *
         *     0   1   2   3   4   5   6
         * 0 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 1 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 2 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 3 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 4 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 5 |   |   |   |   |   |   | 0 |
         *   -   -   -   -   -   -   -   -
         * 6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
         */

        for (int i = k - 1; i >= 0; i--) {
            for (int j = 0; j <= b.size(); j++) {
                if (b.get(j) <= b.get(j + 1)) {
                    h[j][i] = h[j][i + 1];
                } else {
                    h[j][i] = Math.max(1 + h[i][i + 1], h[j][i + 1]);
                }
            }
        }

        return h[t][k];
    }

    //------------ Memoization ------------//

    private static int llisMem(Vector<Integer> s, int t, int k, int[][] h) {
        if (h[t][k] == UNKNOWN) {
            if (k == s.size()) {
                h[t][k] = 0;
            } else if (s.get(k) <= s.get(t)) {
                h[t][k] = llisMem(s, t, k + 1, h);
            } else {
                h[t][k] = Math.max(1 + llisMem(s, k, k + 1, h), llisMem(s, t, k + 1, h));
            }
        }

        return h[t][k];
    }

    public static int llisMemoization(Vector<Integer> s) {
        Vector<Integer> b = new Vector<>(s.size() + 1);

        for (int i = 0; i < s.size(); i++) {
            b.add(s.get(i));
        }

        b.add(0);

        int[][] h = new int[b.size() + 1][b.size() + 1];
        for (int x = 0; x <= b.size(); x++) {
            for (int y = 0; y <= b.size(); y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llisMem(b, b.size() - 1, 0, h);
    }

    public static void main(String[] args) {
        Vector<Integer> a = new Vector<>();
        a.add(3);
        a.add(10);
        a.add(2);
        a.add(1);
        a.add(20);
        System.out.println(a.toString()); // [3, 10, 2, 1, 20]
        System.out.println(llis(a)); // 3 -> (3, 10, 20)
        System.out.println(llisMemoization(a)); // 3 -> (3, 10, 20)
        System.out.println(llisDP(a, 0, 0));
    }
}
