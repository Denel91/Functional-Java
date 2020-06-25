package Laboratorio.Queue_Stack;

/**
 * Definizione della classe Queue<E> che rappresenta una coda: una raccolta di elementi
 * che vengono inseriti e rimossi secondo il principio FIFO (first-in first-out).
 *
 * Queue<E> is mutable, unbounded.
 *
 * Class overview:
 * Queue() : Constructor
 * getSize() : int
 * isEmpty() : boolean
 * enqueue(E data) : void
 * first() : E
 * dequeue() : E
 *
 * @version 25/06/2020
 */
public class Queue<E> {
    // variabili di istanza
    private Node<E> tail;   // nodo finale della coda
    private int size;       // numero di elementi nella coda

    //------------ classe annidata Node ------------ //

    private static class Node<E> {
        private E data;         // riferimento all'elemento memorizzato in questo nodo
        private Node<E> next;   // riferimento al nodo successivo

        public Node(E data, Node<E> n) {
            this.data = data;
            this.next = n;
        }

        public E getElement() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.data = element;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
    }

    /**
     * Default Constructor
     */
    public Queue() {
        this.tail = null;
        this.size = 0;
    }

    /**
     * Restituisce il numero di elementi presenti nella coda.
     *
     * @return il numero di nodi della coda
     */
    public int getSize() {
        return size;
    }

    /**
     * Verifica se la coda è vuota.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Inserisce un elemento in fondo alla coda.
     *
     * @param data l'elemento da inserire nella coda
     */
    public void enqueue(E data) {
        if (size == 0) {
            tail = new Node<>(data, null);
            tail.setNext(tail); // fa riferimento circolarmente a se stesso

        } else {
            Node<E> newest = new Node<>(data, tail.getNext());
            tail.setNext(newest);
            tail = tail.getNext();
        }

        size++;
    }

    /**
     * Restituisce il primo elemento della coda, senza toglierlo (null se è vuota).
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }

        Node<E> head = tail.getNext();
        return head.getElement();
    }

    /**
     * Elimina e restituisce il primo elemento della coda (null se è vuota).
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;  // era l'unico nodo della lista

        } else {
            tail.setNext(head.getNext()); // elimina "head" dalla lista
        }

        size--;
        return head.getElement();
    }

    /**
     * Restituisce una rappresentazione in formato stringa della coda come un elenco di elementi.
     *
     * @return una rappresentazione testuale della coda.
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

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(11);
        queue.enqueue(14);
        queue.enqueue(17);
        System.out.println(queue.isEmpty());    // false
        System.out.println(queue.toString());   // (2, 5, 8, 11, 14, 17)
        System.out.println(queue.first());      // 2
        System.out.println(queue.dequeue());    // 2
        System.out.println(queue.toString());   // (5, 8, 11, 14, 17)
    }
}
