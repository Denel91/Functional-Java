package Laboratorio.Rompicapo_del_15;

/**
 * Data type for Puzzle Board
 *
 * * Class overview:
 * • Un costruttore per istanziare un modello della tavoletta;
 * • Un metodo per verificare se i tasselli sono ordinati;
 * • Un metodo per verificare se un dato tassello può essere spostato;
 * • Un metodo per mostrare in forma testuale (stringa) la configurazione;
 * • Un metodo per spostare un dato tassello.
 *
 * @version 12/05/2020
 */
public class Board {
    private final int size;               // dimensione della tavoletta generalizzata al caso n x x
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
    }

    public int getSize() {
        return size;
    }

    public int getCells() {
        return cells;
    }
}
