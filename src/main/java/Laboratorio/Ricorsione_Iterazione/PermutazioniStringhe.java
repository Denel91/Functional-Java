package Laboratorio.Ricorsione_Iterazione;

import java.util.Vector;
import java.util.Stack;

public class PermutazioniStringhe {

    public static Vector<String> perm(String u) {
        Vector<String> p = new Vector<String>();
        permRec(u, 0, p);
        return p;
    }

    public static void permRec(String u, int k, Vector<String> p) {
        int n = u.length();
        if (k == n - 1) {
            p.add(u);
        } else {
            permRec(u, k + 1, p);
            for (int i = k + 1; i < n; i = i + 1) {
                String v = u.substring(0, k) + u.substring(i, i + 1) + u.substring(k + 1, i) + u.substring(k, k + 1) + u.substring(i + 1, n);
                permRec(v, k + 1, p);
            }
        }
    }

    public static Vector<String> permIter(String u) {
        Vector<String> p = new Vector<String>();
        int n = u.length(), k;
        Stack<String> s = new Stack<String>();
        Stack<Integer> t = new Stack<Integer>();
        s.push(u);
        t.push(0);

        do {
            k = t.pop();
            u = s.pop();

            if (k == n - 1) {
                p.add(u);

            } else {
                s.push(u);
                t.push(k + 1);
                for (int i = k + 1; i < n; i = i + 1) {
                    String v = u.substring(0, k) + u.substring(i, i + 1) + u.substring(k + 1, i) + u.substring(k, k + 1) + u.substring(i + 1, n);
                    s.push(v);
                    t.push(k + 1);
                }
            }

        } while (!s.isEmpty());

        return p;
    }

    public static void main(String[] args) {
        Vector<String> v = permIter("ci");
        System.out.println(v.toString()); // [ci, ic]
    }
}
