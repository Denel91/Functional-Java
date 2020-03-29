package Data_Structures;

import java.util.ArrayList;
import java.util.List;
import java.util.EmptyStackException;
import java.util.Objects;

/**
 * Definizione della classe Stack<E> che rappresenta una pila nella quale gli elementi
 * vengono inseriti e prelevati secondo una modalità detta LIFO (Last In First out):
 * ogni elemento che viene inserito va in cima alla pila e l'ultimo inserito è anche il primo a uscirne.
 *
 * Class overview:
 * size(): int
 * isEmpty(): boolean
 * peek():  Object
 * pop() : Object
 * push(Object e) : void
 * contains​(Object o): boolean
 * search​(Object o) : int
 * clear() : void
 * clone() : Object
 * equals(Stack s) : boolean
 * toString() : String
 */

public class Stack<E> {
    // variabili di istanza
    private int top;  // the index of the item at the top of the stack
    private List<E> elements; // the items of the stack
    private static final int DEFAULT_SIZE = 10; // default stack size

    /**
     * Default Constructor
     */
    public Stack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor (Creator).
     *
     * @param capacity the size of the stack. REQUIRE >= 0
     */
    public Stack(int capacity) {
        capacity = capacity == 0 ? DEFAULT_SIZE : capacity;
        this.top = -1; // Stack inizialmente vuoto
        this.elements = new ArrayList<>(capacity);
    }

    /**
     * @return the size of the stack
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * @return true if this stack contains no elements.
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * @return the object on top of the stack without taking it out
     * @throws EmptyStackException if isEmpty() is true
     */
    public E peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        return elements.get(top);
    }

    /**
     * Delete the item located at the top of the stack
     *
     * @return the item at the top of the stack
     * @throws EmptyStackException if isEmpty() is true
     */
    public E pop() throws EmptyStackException {
        Objects.requireNonNull(this.elements);
        E item;
        if (isEmpty())
            throw new EmptyStackException();

        item = elements.remove(top);
        assert (top == elements.size() - 1);
        return item;
    }

    /**
     * Insert the item on top of the stack
     *
     * @param item the object to insert on top of the stack
     */
    public void push(E item) {
        Objects.requireNonNull(this.elements);
        elements.add(++top, item);
        assert (top == elements.size() - 1);
    }

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>(5);

        System.out.println(myStack.isEmpty()); // true
        System.out.println(myStack.size()); // 0
        myStack.push(5);
        myStack.push(6);
        myStack.push(8);
        myStack.push(2);
        myStack.push(4);
        myStack.push(3);
        System.out.println(myStack.size()); // 6
        System.out.println(myStack.pop()); // 3
        System.out.println(myStack.size()); // 5
    }
}
