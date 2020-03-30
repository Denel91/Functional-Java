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
 * cloneStack() : Object
 * equals(Stack s) : boolean
 * toString() : String
 */

public class Stack<E> {
    // variabili di istanza
    private int capacity; // specifies the maximum capacity of the stack
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
        this.capacity = capacity == 0 ? DEFAULT_SIZE : capacity;
        this.top = -1; // Stack inizialmente vuoto
        this.elements = new ArrayList<>(capacity); // Constructs an empty list with the specified initial capacity.
    }

    /**
     * Calculate the stack size
     *
     * @return the size of the stack
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * @return the default size of the stack
     */
    public static int getDefaultSize() {
        return DEFAULT_SIZE;
    }

    /**
     * @return the current capacity of the stack
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Set a new capacity for the stack
     *
     * @param capacity the new capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the elements of the stack
     */
    public List<E> getElements() {
        return elements;
    }

    /**
     * Verify if the stack is empty
     *
     * @return true if this stack contains no elements.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Fetch the first element of the Stack or the element
     * present at the top of the Stack.
     * The element retrieved does not get deleted or removed from
     * the Stack.
     *
     * @return the object on top of the stack without taking it out
     * @throws EmptyStackException if isEmpty() is true
     *                             PRE-CONDITION top >= 0
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
     *                             PRE-CONDITION top >= 0
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
     *             PRE-CONDITION size < capacity
     */
    public void push(E item) {
        if (size() == capacity)
            throw new IllegalStateException("Stack is full");
        Objects.requireNonNull(this.elements);
        elements.add(++top, item);
        assert (top == elements.size() - 1);
    }

    /**
     * Check if an element is present in the stack
     *
     * @param item the element to verify
     * @return true if this list contains the specified element.
     */
    public boolean contains​(E item) {
        return this.elements.contains(item);
    }

    /**
     * Search the item inside the stack
     *
     * @param item the element to search in the stack
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not
     * contain the element.
     */
    public int search​(E item) {
        return this.elements.indexOf(item);
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear() {
        this.elements.clear();
    }

    /**
     * Clone all elements of the stack
     *
     * @return a copy of the stack
     */
    public List<E> cloneStack() {
        List<E> clone = new ArrayList<>(this.capacity);
        clone.addAll(this.elements);
        return clone;
    }

    /**
     * Verify if two stacks are equals
     *
     * @param eStack the stack to compare
     * @return true if the stacks are equals, false otherwise
     */
    public boolean equals(Stack<E> eStack) {
        if (this.isEmpty()) {

            return eStack.isEmpty();

        } else if (eStack.isEmpty()) {

            return false;

        } else if (this.capacity == eStack.capacity && this.top == eStack.top && this.elements.equals(eStack.elements)) {

            return true;

        } else {

            return false;

        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {

            return "[---]";

        } else {

            return elements.toString();
        }
    }

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>(8);
        Stack<Integer> integerStack = new Stack<>(8);
        Stack<Integer> stack = new Stack<>(6);

        System.out.println("Stack is empty?: " + myStack.isEmpty()); // true
        System.out.println("Size of myStack: " + myStack.size()); // 0

        myStack.push(1);
        myStack.push(6);
        myStack.push(8);
        myStack.push(2);
        myStack.push(4);
        myStack.push(3);

        /***************************************/

        integerStack.push(1);
        integerStack.push(6);
        integerStack.push(8);
        integerStack.push(2);
        integerStack.push(4);
        integerStack.push(3);

        stack.setCapacity(10);

        System.out.println("New Capacity: " + stack.getCapacity()); // 10
        System.out.println(stack.toString()); // [---]
        System.out.println(myStack.toString()); // [1, 6, 8, 2, 4, 3]
        System.out.println("Equals?: " + myStack.equals(integerStack)); // true
        System.out.println("Size after push(): " + myStack.size()); // 6
        System.out.println("Capacity: " + myStack.getCapacity()); // 8
        System.out.println("First element: " + myStack.peek()); // 3
        System.out.println("Item removed: " + myStack.pop()); // 3
        System.out.println("Size after pop(): " + myStack.size()); // 5
        System.out.println("Contains?: " + myStack.contains​(8)); // true
        System.out.println("Search: " + myStack.search​(2)); // 3
    }
}
