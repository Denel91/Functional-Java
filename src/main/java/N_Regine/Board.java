package N_Regine;

import java.util.function.BiPredicate;

/**
 * Rompicapo delle otto regine:
 *
 * È stato dimostrato matematicamente che il problema è risolvibile per n = 1 o n ≥ 4,
 * mentre non lo è per n = 2 e n = 3.
 *
 * Realizzazione del dato astratto "scacchiera" la cui configurazione eveolve aggiungendo o rimuovendo regine.
 *
 * Protocollo della classe "Board"
 *
 * Class overview:
 * new Board(n) : Constructor           crea una scacchiera n x n vuota
 * b.size() : int                       dimensione della scacchiera b
 * b.queensOn() : int                   numero di regine collocate nella scacchiera b
 * b.underAttack(i, j) : boolean        la posizione <i,j> è minacciata?
 * b.arrangement() : String             descrizione "esterna" della configurazione (convenzioni scacchistiche)
 * b.addQueen(i, j) : Board             modifica della configurazione di b aggiungendo una nuova regina in posizione <i,j>
 *
 * @version 17/04/2020
 */

public class Board {
    // Codifica secondo le convenzioni scacchistiche (massima dimensione: 15 x 15)
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";

    // Realizzazione del dato astratto "Scacchiera": stato interno
    private final int size;                             // dimensione scacchiera
    private final int queens;                           // numero regine collocate
    private final BiPredicate<Integer, Integer> attack; // riga, colonna, diagonali minacciate
    private final String config;                        // rappresentazione testuale delle regine

    /**
     * Default Constructor
     *
     * @param n the size of the Board
     */
    public Board(int n) {
        size   = n;
        queens = 0;
        attack = (x, y) -> false; // lambda expression
        config = "";
    }

    /**
     * Constructor
     *
     * @param n size of the Board
     * @param q numbers of queens
     * @param p predicate
     * @param c string representation of the Board
     */
    private Board(int n, int q, BiPredicate<Integer, Integer> p, String c) {
        size   = n;
        queens = q;
        attack = p; // lambda expression
        config = c;
    }

    /**
     * @return the dimension of the Board
     */
    public int size() {
        return size;
    }

    /**
     * @return the number of queens on the Board
     */
    public int queensOn() {
        return queens;
    }

    /**
     * Verify if the position <i,j> is under attack
     *
     * @param i the row index
     * @param j the column index
     * @return true if the position <i,j> is under attack, false otherwise
     */
    public boolean underAttack(int i, int j) {
        return attack.test(i, j);
    }

    /**
     * @return string representation of the Board
     */
    public String arrangement() {
        return config;
    }

    @Override
    public String toString() {
        return "Board {" + "size = " + size + ", queens = " + queens + ", config = '" + config + '\'' + '}';
    }

    /**
     * Add a queen on the Board
     *
     * @param i the row index
     * @param j the column index
     * @return a new Board with an extra queen
     */
    public Board addQueen(int i, int j) {
        return new Board(size, queens + 1,
                         (x, y) -> (x == i) || (y == j) || (x - y == i - j) || (x + y == i + j) || attack.test(x, y),
                         config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ");
    }
} // class Board




