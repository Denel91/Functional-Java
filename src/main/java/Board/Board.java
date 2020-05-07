package Board;

/**
 * Realizzazione del dato astratto "scacchiera"
 *
 * Versione "stato che evolve"
 *
 * new Board(n): Constructor            crea una scacchiera n x n vuota
 * b.size() : int                       dimensione della scacchiera b
 * b.queensOn() : int                   numero di regine collocate nella scacchiera b
 * b.underAttack(i, j) : boolean        la posizione <i,j> è minacciata?
 * b.arrangement() : String             descrizione "esterna" della configurazione (convenzioni scacchistiche)
 * b.addQueen(i, j) : void              modifica della configurazione di b aggiungendo una nuova regina in posizione <i,j>
 *
 * @version 07/05/2020
 */

public class Board {
    // Codifica secondo le convenzioni scacchistiche (massima dimensione: 15 x 15)
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";

    // Realizzazione del dato astratto "Scacchiera": stato interno
    private final int size;         // dimensione scacchiera
    private int queens;             // numero regine collocate
    private int[] rowAttack;        // righe minacciate
    private int[] colAttack;        // colonne minacciate
    private int[] dg1Attack;        // diagonali ascendenti minacciate
    private int[] dg2Attack;        // diagonali discendenti minacciate
    private String config;          // rappresentazione testuale delle regine

    /**
     * Default Constructor
     *
     * @param n the size of the Board
     */
    public Board(int n) {
        this.size = n;
        this.queens = 0;
        this.rowAttack = newArray(n);
        this.colAttack = newArray(n);
        this.dg1Attack = newArray(2 * n - 1);
        this.dg2Attack = newArray(2 * n - 1);
        this.config = "";
    }

    /**
     * Procedura privata di supporto
     *
     * @param k dimensione dell'array
     * @return un array inizializzato a 0 in tutte le sue componenti
     */
    private static int[] newArray(int k) {
        int[] v = new int[k];
        for (int i = 0; i < k; i++) {
            v[i] = 0;
        }

        return v;
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
     * @return string representation of the Board
     */
    public String arrangement() {
        return config;
    }

    @Override
    public String toString() {
        return "Board {" + "[" + arrangement() + "]" + "}";
    }

    /**
     * Verify if the position <i,j> is under attack
     *
     * @param i the row index
     * @param j the column index
     * @return true if the position <i,j> is under attack, false otherwise
     */
    public boolean underAttack(int i, int j) {
        return ((rowAttack[i - 1] > 0) || (colAttack[j - 1] > 0) || (dg1Attack[i - j + size - 1] > 0) || (dg2Attack[i + j - 2] > 0));
    }

    /**
     * Add a queen on the Board
     *
     * @param i the row index
     * @param j the column index
     * @return the Board with an extra queen
     */
    public void addQueen(int i, int j) {
        queens = queens + 1;
        rowAttack[i - 1] = rowAttack[i - 1] + 1;
        colAttack[j - 1] = colAttack[j - 1] + 1;
        dg1Attack[i - j + size - 1] = dg1Attack[i - j + size - 1] + 1;
        dg2Attack[i + j - 2] = dg2Attack[i + j - 2] + 1;
        config = config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ";
    }

    /**
     * Remove a queen on the Board
     *
     * @param i the row index
     * @param j the column index
     * @return the Board without a queen
     */
    public void removeQueen(int i, int j) {
        queens = queens + 1;
        rowAttack[i - 1] = rowAttack[i - 1] - 1;
        colAttack[j - 1] = colAttack[j - 1] - 1;
        dg1Attack[i - j + size - 1] = dg1Attack[i - j + size - 1] - 1;
        dg2Attack[i + j - 2] = dg2Attack[i + j - 2] - 1;
        String pos = config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ";
        int k = config.indexOf(pos);
        config = config.substring(0, k) + config.substring(k + 4);
    }
}
