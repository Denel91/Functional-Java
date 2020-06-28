package Laboratorio.SchemeList;

/**
 * Memoization
 *
 * @version 28/06/2020
 */
public class Memoization {

    public static IntList lis(IntList s) {
        IntList h = new IntList();
        return lisMem(s, 0, h);
    }

    //------------ Versione ricorsiva ------------//

    public static IntList lisRec(IntList s, int t) {
        if (s.isEmpty()) {
            return new IntList();
        } else if (s.car() <= t) {
            return lisRec(s.cdr(), t);
        } else {
            return longer(new IntList(s.car(), lisRec(s.cdr(), s.car())), lisRec(s.cdr(), t));
        }
    }

    //------------ Memoization ------------//

    private static IntList lisMem(IntList s, int t, IntList h) {
        if (s.isEmpty()) {
            h = new IntList();
        } else if (s.car() <= t) {
            h = lisMem(s.cdr(), t, h);
        } else {
            h = longer(new IntList(s.car(), lisMem(s.cdr(), s.car(), h)), lisMem(s.cdr(), t, h));
        }

        return h;
    }

    /**
     * Calcola la lista più lunga tra due liste di interi
     *
     * @param u una lista di Integer
     * @param v una lista di Integer
     * @return la lista più lunga
     */
    public static IntList longer(IntList u, IntList v) {
        if (u.length() < v.length()) {
            return v;
        } else {
            return u;
        }
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        list = new IntList(4, list);
        list = new IntList(8, list);
        list = new IntList(6, list);
        list = new IntList(9, list);
        list = new IntList(3, list);
        list = new IntList(5, list);
        System.out.println(lis(list)); // (5, 6, 8)
    }
}
