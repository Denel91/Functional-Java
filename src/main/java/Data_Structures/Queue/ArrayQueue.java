package Data_Structures.Queue;

public class ArrayQueue<E> implements Queue<E> {
    // costante di classe
    public static final int CAPACITY = 1000;
    // variabili di esemplare
    private E[] data;       // array generico che memorizza gli elementi
    private int f = 0;      // indice dell'elemento iniziale
    private int sz = 0;     // numero di elementi nella coda

    /**
     * Constructor
     * Costruisce una coda con capacità data
     *
     * @param capacity la lunghezza dell'array
     */
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * Constructor
     * Costruisce una coda con capacità standard
     */
    public ArrayQueue() {
        this(CAPACITY);
    }

    /**
     * Restituisce il numero di elementi presenti nella coda.
     */
    @Override
    public int size() {
        return sz;
    }

    /**
     * Verifica se la coda è vuota.
     */
    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    /**
     * Inserisce un elemento in fondo alla coda.
     *
     * @param e l'elemento da inserire nella coda
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    /**
     * Restituisce il primo elemento della coda, senza toglierlo (null se è vuota).
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    /**
     * Elimina e restituisce il primo elemento della coda (null se è vuota).
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E element = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return element;
    }

    /**
     * Restituisce una rappresentazione in formato stringa della coda come un elenco di elementi.
     *
     * @return una rappresentazione testuale della coda.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = f;
        for (int j = 0; j < sz; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[k]);
            k = (k + 1) % data.length;
        }
        sb.append(")");
        return sb.toString();
    }
}
