package Laboratorio.Ricorsione_Iterazione;

import java.util.Stack;

public class Esercizio {

    public static long st(int n, int k) {
        long[] cn = new long[]{0};
        sRec(1, n, k, cn);
        return cn[0];
    }

    private static void sRec(int p, int n, int k, long[] cn) {
        if ((k == 1) || (k == n)) {
            cn[0] = cn[0] + p;
        } else {
            sRec(p, n - 1, k - 1, cn);
            sRec(k * p, n - 1, k, cn);
        }
    }

    public static long stIter(int n, int k) {
        long[] cn = new long[]{0};
        Stack<int[]> stack = new Stack<>();

        int[] f = new int[]{1, n, k};
        stack.push(f);

        while (!stack.isEmpty()) {
            f = stack.pop();
            if ((f[2] == 1) || (f[2] == f[1])) {
                cn[0] = cn[0] + f[0];
            } else {
                // ordine invertito
                stack.push(new int[]{f[2] * f[0], f[1] - 1, f[2]});
                stack.push(new int[]{f[0], f[1] - 1, f[2] - 1});
            }
        }

        return cn[0];
    }
}


