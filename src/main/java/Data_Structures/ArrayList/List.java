package Data_Structures.ArrayList;

/**
 * Una versione semplificata dell'interfaccia java.util.List.
 */
public interface List<E> {
    /**
     * Restituisce il numero di elementi presenti nella lista
     *
     * @return il numero di elementi presenti nella lista.
     */
    int size();

    /**
     * Verifica se la lista è vuota
     *
     * @return true se e solo se la lista è vuota.
     */
    boolean isEmpty();

    /**
     * Restituisce l'elemento corrispondente all'indice i, senza eliminarlo.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @return restituisce l'elemento corrispondente all'indice i, senza eliminarlo.
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Sostituisce con e l'elemento di indice i.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @param e l'elemento da sostituire nella lista
     * @return l'elemento sostituito
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Inserisce e come elemento di indice i, spostando gli elementi successivi.
     *
     * @param i l'indice dell'elemento all'interno della lista
     * @param e l'elemento da inserire nella lista
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Elimina l'elemento di indice i, spostando i successivi
     *
     * @return l'elemento di indice i
     * @throws IndexOutOfBoundsException segnala il passaggio di un indice non valido come parametro
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
