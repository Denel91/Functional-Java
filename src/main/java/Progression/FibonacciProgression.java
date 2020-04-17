package Progression;

public class FibonacciProgression extends Progression {
    protected long prev;

    /**
     * Costruisce la serie di Fibonacci tradizionale: 0, 1, 1, 2, 3, ...
     */
    public FibonacciProgression() {
        this(0, 1);
    }

    /**
     * Costruisce una serie di Fibonacci generalizzata, con primo e secondo valore.
     *
     * @param first  il primo valore della serie
     * @param second il secondo valore della serie
     */
    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first;
    }

    /**
     * Sostituisce (prev, current) con (current, current + prev)
     */
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
