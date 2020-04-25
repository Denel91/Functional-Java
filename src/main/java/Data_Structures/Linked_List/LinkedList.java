package Data_Structures.Linked_List;

import java.util.Iterator;

/**
 * class LinkedList
 *
 * * * Class overview:
 * LinkedList() : Constructor
 * getSize() : int
 * isEmpty() : boolean
 * first() : E
 * last() : E
 * indexOf(E e) : int
 * belong(E e) : boolean
 * addFirst(E e) : void
 * changeFirst(E e) : void
 * removeFirst() : E
 * addLast(E e) : void
 * changeLast(E e) : void
 * toString() : String
 * display(LinkedList<E> list) : void
 * iterator() : Iterator<E>
 *
 * @version 25/04/2020
 */
public class LinkedList<E> implements Iterable<E> {
    // variabili di esemplare di LinkedList
    private Node<E> head;   // nodo iniziale della lista (o null se è vuota)
    private Node<E> tail;   // nodo finale della lista (o null se è vuota)
    private int size;       // numeri di nodi della lista

    /**
     * Constructor
     *
     * Costruisce una lista inizialmente vuota
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //------------ metodi di accesso ------------

    /**
     * @return the dimension of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @return il primo elemento della lista senza eliminarlo
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * @return l'ultimo elemento della lista senza eliminarlo
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * @param e un generico elemento della lista
     * @return l'indice nella lista della prima occorrenza dello specificato
     * elemento, o -1 se la lista non contiene l'elemento.
     */
    public int indexOf(E e) {
        if (size == 0) {
            return -1;
        }
        if (first().equals(e)) {
            return 0;

        } else if (last().equals(e)) {
            return size - 1;

        } else {
            Node<E> tmpNode = head;
            int index = 0;
            while (index < size) {
                if (tmpNode.element.equals(e)) {
                    return (index);
                }
                index++;
                tmpNode = tmpNode.getNext();
            }
        }
        return -1;
    }

    /**
     * Verifica se un elemento appartiene alla lista
     *
     * @param e un generico elemento da verificare
     * @return true se l'elemento appartiene alla lista, falso altrimenti.
     */
    public boolean belong(E e) {
        return this.indexOf(e) != -1;
    }

    //------------ metodi di aggiornamento ------------

    /**
     * Aggiunge l'elemento e all'inizio della lista
     *
     * @param e the elemento to add at the begin in the list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (getSize() == 0) {
            tail = head; // caso speciale: il nuovo nodo diventa anche tail
        }
        size++;
    }

    /**
     * Modifica il valore dell'elemento in testa alla lista
     *
     * @param e il nuovo elemento che modifica l'elemento in testa alla lista
     */
    public void changeFirst(E e) throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("La lista è vuota!");
        }

        head.setElement(e);
    }

    /**
     * Elimina il primo elemento e lo restituisce
     *
     * @return the first element removed from the list
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null; // non c'è niente da eliminare
        }
        E answer = head.getElement();
        head = head.getNext(); // diventa null se la lista ha un solo nodo
        size--;
        if (getSize() == 0) {
            tail = null; // caso speciale: ora la lista è vuota
        }
        return answer;
    }

    /**
     * Aggiunge l'elemento e alla fine della lista
     *
     * @param e the element to add at the end of the list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest; // caso speciale: lista inizialmente vuota
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /**
     * Modifica il valore dell'elemento in coda alla lista
     *
     * @param e il nuovo elemento che modifica l'elemento in coda alla lista
     */
    public void changeLast(E e) throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("La lista è vuota!");
        }

        tail.setElement(e);
    }

    @Override
    public String toString() {
        return "(" + head + ")";
    }

    public void display(LinkedList<E> list) {
        String s = "(";
        String t = ")";

        System.out.print(s);

        for (E value : list) {
            if (head != null) {
                System.out.print(value + ", ");

            } else {
                System.out.print(value);
            }
        }

        System.out.print(t);
    }

    @Override
    public Iterator<E> iterator() {
        LinkedList<E> c = this;

        return new Iterator<>() {
            private final LinkedList<E> current = c;

            @Override
            public boolean hasNext() {
                return current != null && head != null;
            }

            @Override
            public E next() {
                E i = current.first();
                head = head.getNext();
                return i;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    //------------ classe annidata Node ------------
    private static class Node<E> {
        private E element; // riferimento all'elemento memorizzato in questo nodo
        private Node<E> next; // riferimento al nodo successivo nella lista

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next    = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }

        @Override
        public String toString() {
            return element + ", " + next;
        }
    }
}
