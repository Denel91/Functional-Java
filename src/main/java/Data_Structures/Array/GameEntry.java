package Data_Structures.Array;

public class GameEntry {
    private String name; // nome del giocatore
    private int score; // punteggio

    /**
     * Costruisce una registrazione di punteggio usando i valori forniti
     * @param n nome del giocatore
     * @param s punteggio
     */
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
