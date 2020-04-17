package N_Regine;

import Liste.StringSList;

/**
 * Soluzione del rompicapo delle N regine
 *
 * @version 17/04/2020
 */
public class Queens {

    public static StringSList listaDiSoluzioni(int n) {
        return listaDiCompletamenti(new Board(n));
    }

    public static StringSList listaDiCompletamenti(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            return StringSList.NULL_STRINGLIST.cons(b.arrangement());

        } else { // q < n

            int i = q + 1;
            StringSList sl = StringSList.NULL_STRINGLIST;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    sl = sl.append(listaDiCompletamenti(b.addQueen(i, j)));
                }
            }

            return sl;
        }
    }

    public static int numeroDiSoluzioni(int n) {
        return numeroDiCompletamenti(new Board(n));
    }

    private static int numeroDiCompletamenti(Board b) {

        int n = b.size();
        int q = b.queensOn();

        if (q == n) {

            return 1;

        } else { // q < n

            int i = q + 1;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    count += numeroDiCompletamenti(b.addQueen(i, j));
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        // Creo due oggetti di tipo Board
        Board c = new Board(4);
        Board t = new Board(5);
        // Creo la lista vuota
        BoardSList list = new BoardSList();
        list = new BoardSList(c, list);
        list = list.cons(t);
        System.out.println(list.length()); // 2
        System.out.println(list.car().arrangement()); // ""
        System.out.println(Queens.listaDiCompletamenti(c)); // ( b1  d2  a3  c4 ,  c1  a2  d3  b4 )

        System.out.println(c.queensOn()); // 0
        System.out.println(Queens.numeroDiSoluzioni(4)); // 2
        System.out.println(Queens.listaDiSoluzioni(4)); // ( b1  d2  a3  c4 ,  c1  a2  d3  b4 )
        System.out.println(Queens.listaDiSoluzioni(4).car()); // b1  d2  a3  c4
    }
} // class Queens




