package Data_Structures.Queue;

/**
 * Interfaccia Queue che definisce l'ADT coda, caratterizzato da un protocollo FIFO
 * per la gestione di inserimenti e rimozioni.
 */
public interface Queue<E> {
    /**
     * Restituisce il numero di elementi presenti nella coda.
     */
    int size();

    /**
     * Verifica se la coda è vuota.
     */
    boolean isEmpty();

    /**
     * Inserisce un elemento in fondo alla coda.
     */
    void enqueue(E e);

    /**
     * Restituisce il primo elemento della coda, senza toglierlo (null se è vuota).
     */
    E first();

    /**
     * Elimina e restituisce il primo elemento della coda (null se è vuota).
     */
    E dequeue();
}
