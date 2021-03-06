package Laboratorio.Queens_Gui;

import Liste.SList;

/**
 * Definizione della classe Scacchiera
 *
 * Protocollo della classe "Board"
 * Class overview:
 * Board(int n) : Default Constructor
 * Board(int n, int q, IntSList row, IntSList col, IntSList dg1, IntSList dg2, String c) : Constructor
 * getSize() : int
 * getQueens() : int
 * underAttack(int i, int j) : boolean
 * addQueen(int i, int j) : Board
 * arrangement() : String
 * toString() : String
 *
 * @version 26/04/2020
 */
public class Board {
    // Codifica secondo le convenzioni scacchistiche (massima dimensione: 15 x 15)
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";

    // Realizzazione del dato astratto "Scacchiera": stato interno
    private final int size;                                // 1) dimensione scacchiera
    private final int queens;                              // 2) numero regine collocate
    private final SList<Integer> queensAttackingRow;       // 3) righe sotto scacco
    private final SList<Integer> queensAttackingCol;       // 4) colonne sotto scacco
    private final SList<Integer> queensAttackingDg1;       // 5) diagonale / sotto scacco
    private final SList<Integer> queensAttackingDg2;       // 6) diagonale \ sotto scacco
    private final String config;                           // 7) rappresentazione testuale delle regine (disposizione)

    /**
     * Default Constructor (public)
     *
     * @param n the size of the Board
     */
    public Board(int n) {
        this.size = n;
        this.queens = 0;
        this.queensAttackingRow = new SList<>();
        this.queensAttackingCol = new SList<>();
        this.queensAttackingDg1 = new SList<>();
        this.queensAttackingDg2 = new SList<>();
        this.config = "";
    }

    /**
     * Constructor
     *
     * @param n   the size of the Board
     * @param q   the number of queens
     * @param row list of the rows
     * @param col list of the columns
     * @param dg1 list of ascending diagonal /
     * @param dg2 list of descending diagonals \
     * @param c   string representation of the Board
     */
    private Board(int n, int q, SList<Integer> row, SList<Integer> col, SList<Integer> dg1, SList<Integer> dg2, String c) {
        this.size = n;
        this.queens = q;
        this.queensAttackingRow = row;
        this.queensAttackingCol = col;
        this.queensAttackingDg1 = dg1;
        this.queensAttackingDg2 = dg2;
        this.config = c;
    }

    /**
     * @return the dimension of the Board
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the number of queens on the Board
     */
    public int getQueens() {
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
        return this.queensAttackingRow.belong(i) || this.queensAttackingCol.belong(j) || this.queensAttackingDg1.belong(i - j) || this.queensAttackingDg2.belong(i + j);
    }

    /**
     * Add a queen on the Board
     *
     * @param i the row index
     * @param j the column index
     * @return a new Board with an extra queen
     */
    public Board addQueen(int i, int j) {
        return new Board(size, queens + 1, queensAttackingRow.cons(i), queensAttackingCol.cons(j),
                         queensAttackingDg1.cons(i - j), queensAttackingDg2.cons(i + j),
                         config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ");
    }

    /**
     * @return the disposition of the queens on the Board
     */
    public String arrangement() {
        return config;
    }

    @Override
    public String toString() {
        return "<" + config + ">";
    }
}


