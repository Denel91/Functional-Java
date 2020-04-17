package Progression;

/**
 * Genera una semplice progressione: 0, 1, 2, 3, ...
 *
 * Class overview:
 * Progression() : Default Constructor
 * Progression(long start) : Constructor
 * nextValue() : long
 * advance() : void
 * printProgression(int n) : void
 */
public class Progression {
    // variabile di istanza
    protected long current;

    /**
     * Costruisce una progressione che parte da zero.
     */
    public Progression() {
        this(0);
    }

    /**
     * Costruisce una progressione con il valore iniziale dato
     *
     * @param start valore iniziale della progressione
     */
    public Progression(long start) {
        current = start;
    }

    /**
     * @return il valore successivo della progressione
     */
    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    /**
     * Assegna a current il valore successivo della progressione
     */
    protected void advance() {
        current++;
    }

    /**
     * Visualizza i successivi n valori, separati da spazi
     *
     * @param n quanti valori ha la progressione
     */
    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int j = 1; j < n; j++)
             System.out.print(" " + nextValue());
        System.out.println();
    }
}
