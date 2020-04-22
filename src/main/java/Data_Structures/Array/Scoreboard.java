package Data_Structures.Array;

/**
 * Classe che memorizza punteggi in un array
 */
public class Scoreboard {
    private int numEntries = 0; // numero di punteggi memorizzati
    private GameEntry[] board;  // array dei dati memorizzati

    /**
     * Costruisce un segnapunti vuoto con la capacità massima assegnata
     *
     * @param capacity the size of the array
     */
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public int getNumEntries() {
        return numEntries;
    }

    /**
     * Aggiunge un nuovo punteggio al segnapunti
     *
     * @param e il punteggio
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // il nuovo punteggio e ha diritto di entrare nel segnapunti?
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) { // nessun punteggio deve uscire dal segnapunti
                numEntries++; // quindi il numero dei punteggi presenti aumenta
            }

            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            board[j] = e;
        }
    }

    /**
     * Elimina e restituisce il punteggio che si trova all'indice i
     *
     * @param i the index of the element
     * @return the score removed from the Board
     * @throws IndexOutOfBoundsException
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > numEntries) {
            throw new IndexOutOfBoundsException("Invalid index " + i);
        }

        GameEntry temp = board[i]; // memorizza l'oggetto da rimuovere
        for (int j = i; j < numEntries - 1; j++) // conta da i in avanti
             board[j] = board[j + 1]; // sposta di un posto verso sinistra
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }

    /**
     * @return a string representation of the high scores list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j < numEntries; j++) {
            if (j > 0) {
                sb.append(",");
            }
            sb.append(board[j]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scoreboard highscores = new Scoreboard(5);

        String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
        int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

        for (int i = 0; i < names.length; i++) {
            GameEntry gE = new GameEntry(names[i], scores[i]);
            System.out.println("Adding " + gE);
            highscores.add(gE);
            System.out.println(" Scoreboard: " + highscores);
            System.out.println(highscores.getNumEntries());
        }
    }
}
