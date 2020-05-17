package Data_Structures.Linked_List;

/**
 * class CircularlyLinkedList
 *
 * * * Class overview:
 * CircularlyLinkedList() : Constructor
 * getSize() : int
 * isEmpty() : boolean
 * first() : E
 * last() : E
 * rotate() : void
 * addFirst(E e) : void
 * addLast(E e) : void
 * removeFirst() : E
 * toString() : String
 *
 * @version 17/05/2020
 */

public class CircularlyLinkedList<E> {

    //------------ classe CircularlyLinkedList<E> ------------

    // variabili di istanza di CircularlyLinkedList
    private Node<E> tail;   // nodo finale della lista
    private int size;       // numero di nodi della lista

    /**
     * Costruisce una lista inizialmente vuota
     * Default Constructor
     */
    public CircularlyLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    //------------ metodi di accesso ------------

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement(); // il primo nodo è il SUCCESSIVO dell'ultimo
    }

    /**
     * Returns (but does not remove) the last element of the list
     *
     * @return element at the back of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    //------------ metodi di aggiornamento ------------

    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {
        if (tail != null) {        // se la lista è vuota non fa niente
            tail = tail.getNext(); // il primo nodo diventa l'ultimo
        }
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // fa riferimento circolarmente a se stesso
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
        addFirst(e);            // inserisce il nuovo elemento all'inizio
        tail = tail.getNext();  // ora il nuovo elemento è diventato l'ultimo
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;        // non c'è niente da eliminare
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;        // era l'unico nodo della lista
        } else {
            tail.setNext(head.getNext()); // elimina "head" dalla lista
        }
        size--;
        return head.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     */
    @Override
    public String toString() {
        if (tail == null) {
            return "()";
        }
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail) {
                sb.append(", ");
            }
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    //------------ classe annidata Node ------------

    private static class Node<E> {
        private E element;      // riferimento all'elemento memorizzato in questo nodo
        private Node<E> next;   // riferimento al nodo successivo nella lista

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
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
            return "" + element + "";
        }
    }
}
