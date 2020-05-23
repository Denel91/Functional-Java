package Data_Structures.Pila;

import Data_Structures.Linked_List.LinkedList;

/**
 * Implementazione dell'ADT "Stack" realizzato con una lista semplicemente concatenata.
 *
 * La cima della pila è rappresentata dall'estremità iniziale della lista,
 * poichè è possibile effettuare inserimenti e rimozioni di elementi in un tempo costante.
 *
 * @version 23/05/2020
 */
public class LinkedStack<E> implements Stack<E> {
    // variabile di istanza
    private LinkedList<E> list; // rappresentazione interna dello Stack

    /**
     * Constructor
     */
    public LinkedStack() {
        list = new LinkedList<>();
    }

    /**
     * Restituisce il numero di elementi presenti nella pila
     *
     * @return il numero di elementi presenti nella pila
     */
    @Override
    public int size() {
        return list.getSize();
    }

    /**
     * Verifica se la pila è vuota
     *
     * @return true se e solo se la pila è vuota
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Inserisce un elemento in cima alla pila
     *
     * @param element l'elemento da inserire
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     * Restituisce l'elemento in cima alla pila, senza eliminarlo
     *
     * @return l'elemento in cima alla pila (o null se la pila è vuota)
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     * Elimina e restituisce l'elemento che si trova in cima alla pila
     *
     * @return l'elemento eliminato (o null se la pila è vuota)
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * Produce una rappresentazione in formato stringa del contenuto dello stack.
     *
     * @return la rappresentazione testuale dello stack
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
