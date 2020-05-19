package Data_Structures.Pila;

/**
 * Implementation of the stack ADT using a fixed-length array.
 * All operations are performed in constant time.
 * An exception is thrown if a push operation is attempted
 * when the size of the stack is equal to the length of the array.
 */
public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;    // capacità iniziale dell'array
    private E[] data;                           // array generico usato per gli elementi
    private int t = -1;                         // indice dell'elemento in cima alla pila

    /**
     * Constructor
     * Costruisce una pila di capacità data
     *
     * @param capacity la capacità da assegnare alla pila
     */
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * Constructor
     * Costruisce una pila di capacità standard
     */
    public ArrayStack() {
        this(CAPACITY);
    }

    /**
     * Restituisce il numero di elementi presenti nella pila
     *
     * @return il numero di elementi presenti nella pila
     */
    @Override
    public int size() {
        return (t + 1);
    }

    /**
     * Verifica se la pila è vuota
     *
     * @return true se e solo se la pila è vuota
     */
    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    /**
     * Inserisce un elemento in cima alla pila
     *
     * @param e l'elemento da inserire
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e; // incrementa t prima di usarlo
    }

    /**
     * Restituisce l'elemento in cima alla pila, senza eliminarlo
     *
     * @return l'elemento in cima alla pila (o null se la pila è vuota)
     */
    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    /**
     * Elimina e restituisce l'elemento che si trova in cima alla pila
     *
     * @return l'elemento eliminato (o null se la pila è vuota)
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = data[t];
        data[t] = null; // per aiutare il garbage collector
        t--;
        return item;
    }

    /**
     * Produces a string representation of the contents of the stack.
     *
     * @return textual representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size(); j++) {
            sb.append(data[j]);
            if (j < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
