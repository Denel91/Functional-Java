package Data_Structures.ArrayList;

/**
 * Implementazione del tipo di dato astratto "lista"
 */
public class ArrayList<E> implements List<E> {
    // variabili di esemplare
    public static final int CAPACITY = 20;      // capacità predefinita dell'array
    private final E[] data;                     // array generico per memorizzare gli elementi
    private int size = 0;                       // numero di elementi nella lista

    // Costruttori

    /**
     * Constructor
     *
     * Costruisce una lista con capacità data
     */
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * Costruisce una lista con capacità standard
     */
    public ArrayList() {
        this(CAPACITY);
    }

    /**
     * Restituisce il numero di elementi presenti nella lista
     *
     * @return il numero di elementi presenti nella lista.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica se la lista è vuota
     *
     * @return true se e solo se la lista è vuota.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Restituisce l'elemento corrispondente all'indice i, senza eliminarlo.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @return restituisce l'elemento corrispondente all'indice i, senza eliminarlo.
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        ckeckIndex(i, size);
        return data[i];
    }

    /**
     * Sostituisce con e l'elemento di indice i.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @param e l'elemento da sostituire nella lista
     * @return l'elemento sostituito
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        ckeckIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserisce e come elemento di indice i, spostando gli elementi successivi.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @param e l'elemento da inserire nella lista
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        ckeckIndex(i, size + 1);
        if (size == data.length) { // non c'è spazio sufficiente
            throw new IllegalStateException("Array is full");
        }

        for (int k = size - 1; k >= i; k--)  // fa scorrere verso destra a partire da destra
             data[k + 1] = data[k];
        data[i] = e;
        size++;
    }

    /**
     * Elimina l'elemento di indice i, spostando i successivi
     *
     * @return l'elemento di indice i
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        ckeckIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)
             data[k] = data[k + 1];
        data[size - 1] = null;
        size--;
        return temp;
    }

    // metodo ausiliario

    /**
     * Controlla se l'indice dato appartiene all'intervallo [0, n-1].
     *
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    protected void ckeckIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Produce una rappresentazione in formato stringa del contenuto della lista
     *
     * @return rappresentazione testuale della lista ArrayList
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[j]);
        }
        sb.append(")");
        return sb.toString();
    }
}
