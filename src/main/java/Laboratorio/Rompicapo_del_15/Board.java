package Laboratorio.Rompicapo_del_15;

import puzzleboard.PuzzleBoard;
import java.util.Random;

// ---------- PARTE I ----------

/**
 * Data type for "Puzzle Board"
 *
 * * Class overview:
 * Board(int n) : Constructor
 * getSize() : int
 * getCells() : int
 * isSorted() : boolean
 * isFree(int dowel) : boolean
 * slide(int dowel) : void
 * shuffle() : void
 * viewBoard() : String
 *
 * @version 16/05/2020
 */
public class Board {
    private final int size;               // dimensione della tavoletta generalizzata al caso n x n
    private static final int HOLE = 0;    // rappresentazione del quadratino vuoto (lacuna)
    private final int cells;              // numero di tasselli nella tavoletta n x n
    private int[][] board;                // rappresentazione interna della tavoletta come matrice -> Dalle coordinate ottengo il numero memorizzato in quella cella.
    private int[] u;                      // dal numero del tassello ottengo le coordinate della riga
    private int[] v;                      // dal numero del tassello ottengo le coordinate della colonna

    /**
     * Costruttore della tavoletta n x n (ordinata)
     *
     * @param n dimensione della tavoletta
     */
    public Board(int n) {
        this.size  = n;
        this.cells = n * n;
        this.board = new int[n][n];
        this.u = new int[cells];
        this.v = new int[cells];
        int t = 0;

        // Disposizione ordinata di tutti i tasselli da 1 a 15
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                t = (t + 1) % cells; // numerati da 1 a 15 con la lacuna in ultima posizione
                board[i][j] = t;
                u[t] = i;
                v[t] = j;
            }
        }

        shuffle(); // randomizza la disposizione dei tasselli all'interno della Board
    }

    /**
     * Returns the dimension of the Board
     *
     * @return the dimension of the Board
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the number of the cells in the Board
     *
     * @return the number of the cells in the Board
     */
    public int getCells() {
        return cells;
    }

    /**
     * Verify if the Board is sorted
     *
     * @return true if the Board is sorted, false otherwise
     */
    public boolean isSorted() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (board[i][j] > board[i][j + 1]) {
                    if (board[i][j] > board[i + 1][j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Check if a given piece can be moved
     *
     * @param dowel the piece to be moved
     * @return true if the piece can be moved, false otherwise
     */
    public boolean isFree(int dowel) {
        if ((dowel > 0) && (dowel < cells)) {
            int dx = Math.abs(u[dowel] - u[HOLE]); // calcolo la distanza tra le righe
            int dy = Math.abs(v[dowel] - v[HOLE]); // calcolo la distanza tra le colonne

            return (dx + dy == 1);
        }

        return false;
    }

    /**
     * Move a given piece
     *
     * @param dowel the piece to be moved
     */
    public void slide(int dowel) {
        if (isFree(dowel)) {
            int i1 = u[dowel];
            int j1 = v[dowel];
            int i2 = u[HOLE];
            int j2 = v[HOLE];

            board[i1][j1] = HOLE;   // sposto la lacuna nella casella del pezzo
            board[i2][j2] = dowel;  // sposto il pezzo nella casella della lacuna
            u[HOLE] = i1;
            v[HOLE] = j1;
            u[dowel] = i2;
            v[dowel] = j2;
        }
    }

    /**
     * Generate a random matrix in the range from 1 to 15
     */
    public void shuffle() {
        Random rgen = new Random();  // Random number generator
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int randomPosition = rgen.nextInt(size - 1);
                int temp = board[i][j];
                board[i][j] = board[randomPosition][randomPosition];
                board[randomPosition][randomPosition] = temp;
                u[board[i][j]] = i;
                v[board[i][j]] = j;
            }
        }
    }

    /**
     * Show the configuration
     *
     * @return the configuration in text form (String)
     */
    public String viewBoard() {
        String conf = "";
        String spaces = "  ";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == HOLE) {
                    conf += "  " + spaces;

                } else {
                    String numbers = "" + board[i][j];
                    numbers = spaces.substring(numbers.length()) + numbers;
                    conf += "  " + numbers;
                }
            }

            conf += "\n";
        }

        return conf;
    }

    // ---------- PARTE II ----------

    /**
     * Visualizzazione della Tavoletta
     *
     * @return the view of PuzzleBoard
     */
    public PuzzleBoard view() {
        PuzzleBoard view = new PuzzleBoard(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != HOLE) {
                    view.setNumber(i + 1, j + 1, board[i][j]);
                }
            }
        }

        return view;
    }

    /**
     * Sposta un pezzo all'interno della tavoletta
     *
     * @param t il pezzo da spostare
     * @param view la tavoletta in forma grafica
     */
    public void slide(int t, PuzzleBoard view) {

        int i = u[t];       // registro in i la coordinata di riga del pezzo
        int j = v[t];       // registro in j la coordinata di colonna del pezzo
        int i2 = u[HOLE];   // registro in i2 la coordinata di riga della lacuna
        int j2 = v[HOLE];   // registro in j2 la coordinata di colonna della lacuna

        if (Math.abs(i - i2) + Math.abs(j - j2) == 1) { // se la loro distanza è 1 allora la lacuna e il tassello
            // sono adiacenti

            board[i2][j2] = t;      // sposto il pezzo nella casella della lacuna
            board[i][j] = HOLE;     // sposto la lacuna nella casella del pezzo
            u[t] = i2;              // nuova coordinata di riga del pezzo
            v[t] = j2;              // nuova coordinata di colonna del pezzo
            u[HOLE] = i;            // nuova coordinata di riga della lacuna
            v[HOLE] = j;            // nuova coordinata di colonna della lacuna

            if (view != null) {
                view.clear(i + 1, j + 1);   // cancello il tassello in posizione <i,j> che ho spostato
                view.setNumber(i2 + 1, j2 + 1, board[i2][j2]);
            }
        }
    }

    public static void main(String[] args) {
        Board b = new Board(4);
        System.out.println(b.viewBoard());
        System.out.println(b.isSorted());
        System.out.println(b.isFree(7));

        // ---------- PARTE II ----------

        PuzzleBoard v = b.view();
        v.display();
        while (!b.isSorted()) {
            int p = v.get();
            System.out.printf("%d\n", p);
            b.slide(p, v);
            v.display();
        }

        System.out.println("Done!");
    }
}
