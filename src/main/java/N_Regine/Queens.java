package N_Regine;

import Liste.BoardSList;
import Liste.SList;
import Liste.StringSList;

/**
 * Soluzione del rompicapo delle N regine
 *
 * Class overview:
 * listOfSolutions(int n) : SList<Board>
 * listOfCompletations(Board t) : SList<Board>
 * numeroDiSoluzioni(int m, int n) : SList<Integer>
 * listaDiSoluzioni(int n) : StringSList
 * listaDiCompletamenti(Board b) : StringSList
 * numeroDiSoluzioni(int n) : int
 * numeroDiCompletamenti(Board b) : int
 * listaSoluzioni(int n) : BoardSList
 * listaSoluzioni(int n) : BoardSList
 *
 * @version 21/04/2020
 */
public class Queens {

    public static SList<Board> listOfSolutions(int n) {
        return listOfCompletations(new Board(n));
    }

    public static SList<Board> listOfCompletations(Board t) {
        int n = t.size();
        int q = t.queensOn();

        if (q == n) {
            return new SList<Board>().cons(t);

        } else { // q < n

            int i = q + 1;
            SList<Board> sl = new SList<>();
            for (int j = 1; j <= n; j++) {
                if (!t.underAttack(i, j)) {
                    sl = sl.append(listOfCompletations(t.addQueen(i, j)));
                }
            }

            return sl;
        }
    }

    /**
     * Numero di soluzioni
     * Il numero di modi diversi in cui si possono disporre n regine in una scacchiera n x n
     *
     * @param m dimensione minima di Board
     * @param n dimensione massima di Board
     * @return a new SList<Integer>
     */
    public static SList<Integer> numeroDiSoluzioni(int m, int n) {
        if (m > n) {
            return new SList<>();
        } else {
            return numeroDiSoluzioni(m + 1, n).cons(numeroDiSoluzioni(m));
        }
    }

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

    /**
     * Numero di soluzioni:
     *
     * Il numero di modi diversi in cui si possono disporre n regine
     * in una scacchiera n x n è dato dal numero di modi diversi in
     * cui si può completare la disposizione delle regine:
     *
     * --> numberOfCompletions(new Board(n))
     *
     * a partire da una scacchiera n x n inizialmente vuota
     *
     * @param n the size of the Board
     */
    public static int numeroDiSoluzioni(int n) {
        return numeroDiCompletamenti(new Board(n));
    }

    /**
     * Il numero di modi in cui si può completare la disposizione
     * a partire da una scacchiera b parzialmente configurata
     *
     * --> numberOfCompletions(b) : int
     *
     * dove k regine (0 <= k < n) sono collocate nelle prime k righe
     * di b, si può determinare a partire dalle configurazioni
     * che si ottengono aggiungendo una regina nella riga k + 1 in tutti
     * i modi possibili (nelle posizioni che non sono già minacciate)
     *
     * for ( int j = 1; j <= n; j = j+1 ) {
     *      if (!b.underAttack(i,j)) {
     *          ... b.addQueen(i,j) ...
     *      }
     * }
     *
     * calcolando ricorsivamente per ciascuna di queste il numero
     * di modi in cui si può completare la disposizione
     *
     * --> numberOfCompletions(b.addQueen(i,j))
     *
     * e sommando i valori che ne risultano
     *
     * --> count = count + numberOfCompletions(...)
     *
     * Se invece la scacchiera rappresenta una soluzione (q == n)
     * c'è un solo modo (banale) di completare la disposizione:
     * lasciare le cose come stanno!
     *
     * @param b a Board Object
     */
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

    public static BoardSList listaSoluzioni(int n) {
        return completamenti(new Board(n));
    }

    private static BoardSList completamenti(Board b) {
        int dimensioneScacchiera = b.size();
        int queens = b.queensOn();

        if (queens == dimensioneScacchiera) {
            return BoardSList.NULL_BOARDLIST.cons(b);

        } else {
            int i = queens + 1;
            BoardSList sList = BoardSList.NULL_BOARDLIST;
            for (int j = 1; j <= dimensioneScacchiera; j++) {
                if (!b.underAttack(i, j)) {
                    sList = sList.append(completamenti(b.addQueen(i, j)));
                }
            }

            return sList;
        }
    }

    public static void main(String[] args) {
        // Creo due oggetti di tipo Board
        Board c = new Board(4);
        Board t = new Board(5);
        // Creo la lista vuota e aggiungo due Board
        BoardSList list = new BoardSList();
        list = new BoardSList(c, list);
        list = list.cons(t);

        System.out.println(c.addQueen(3, 2));        // Board {[ b3 ]}
        System.out.println(c.addQueen(3, 3));        // Board {[ c3 ]}
        System.out.println(c.insertQueen(3, 4));    // Board {[ d3 ]}

        // una lista vuota
        BoardSList sList = new BoardSList();

        System.out.println(sList.toString());       // (---)
        System.out.println(list.toString());        // (Board {[]}, Board {[]})
        System.out.println(list.car());             // Board {[]}
        System.out.println(list.cdr());             // (Board {[]})
        System.out.println(list.length());          // 2
        System.out.println(Queens.listaDiCompletamenti(c));    // ( b1  d2  a3  c4 ,  c1  a2  d3  b4 )
        System.out.println(Queens.numeroDiSoluzioni(4));    // 2
        System.out.println(Queens.listaDiSoluzioni(4));     // ( b1  d2  a3  c4 ,  c1  a2  d3  b4 )
        System.out.println(Queens.listaSoluzioni(4));       // (Board {[ b1  d2  a3  c4 ]}, Board {[ c1  a2  d3  b4 ]})
        System.out.println(Queens.listaSoluzioni(1));       // (Board {[ a1 ]})
        System.out.println(Queens.numeroDiSoluzioni(1, 4)); // (1, 0, 0, 2)
        System.out.println(Queens.listOfSolutions(4)); // (Board {[ b1  d2  a3  c4 ]}, Board {[ c1  a2  d3  b4 ]})
    }
} // class Queens




