package Laboratorio.Queue_Stack;

import java.util.EmptyStackException;

/**
 * Definizione della classe Stack<E> che rappresenta una pila nella quale gli elementi
 * vengono inseriti e prelevati secondo una modalità detta LIFO (Last In First out):
 * Ogni elemento che viene inserito va in cima alla pila e l'ultimo inserito è anche il primo a uscirne.
 *
 * Stack<E> is mutable, unbounded.
 *
 * Class overview:
 * Stack() : Constructor
 * getSize() : int
 * isEmpty() : boolean
 * peek() : E
 * push(E data) : void
 * pop() : E
 *
 * @version 25/06/2020
 */
public class Stack<E> {
    // variabili di istanza
    private Node<E> head;  // nodo in cima allo Stack
    private int size;      // numeri di nodi dello Stack

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
    public Stack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Restituisce il numero dei nodi presenti nello Stack
     *
     * @return la dimensione dello Stack
     */
    public int getSize() {
        return size;
    }

    /**
     * Verifica se lo Stack è vuoto
     */
    public boolean isEmpty() {
        return (this.head == null);
    }

    /**
     * Recupera il primo elemento dello Stack o l'elemento presente nella parte superiore dello Stack.
     * L'elemento recuperato non viene eliminato o rimosso dallo Stack.
     *
     * @return l'oggetto in cima alla pila senza eliminarlo
     * @throws EmptyStackException se isEmpty() è true
     */
    public E peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return this.head.data;
    }

    /**
     * Inserisce l'elemento in cima alla pila
     *
     * @param data l'oggetto da inserire in cima alla pila
     */
    public void push(E data) {
        Node<E> newNode = new Node<>(data, null);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    /**
     * Elimina l'elemento situato nella parte superiore della pila
     *
     * @return l'oggetto in cima alla pila
     * @throws EmptyStackException se isEmpty() è true
     */
    public E pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        E poppedData = this.head.data;
        this.head = this.head.next;
        size--;
        return poppedData;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty()); // true
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        System.out.println(stack.peek()); // 8
        System.out.println(stack.pop()); // 8
        System.out.println(stack.getSize()); // 3
        System.out.println(stack.peek()); // 6
    }
}
