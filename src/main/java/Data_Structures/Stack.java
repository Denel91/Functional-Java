package Data_Structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Definizione della classe Stack<E> che rappresenta una pila nella quale gli elementi
 * vengono inseriti e prelevati secondo una modalità detta LIFO (Last In First out):
 * ogni elemento che viene inserito va in cima alla pila e l'ultimo inserito è anche il primo a uscirne.
 *
 * Class overview:
 * isEmpty(): boolean
 * top() : Object
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
    private int top;
    private List<E> elements;
    private static final int DEFAULT_SIZE = 5;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        size = size == 0 ? DEFAULT_SIZE : size;
        this.top = -1; // Stack inizialmente vuoto
        this.elements = new ArrayList<>(size);
    }

    public int size() {
        return this.elements.size();
    }
}
