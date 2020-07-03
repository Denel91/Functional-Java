package Data_Structures.Linked_List;

/**
 * Un'implementazione di base di una lista doppiamente concatenata.
 *
 * Class overview:
 * DoublyLinkedList() : Constructor
 * getSize() : int
 * isEmpty() : boolean
 * first() : E
 * last() : E
 * addFirst(E e) : void
 * addLast(E e) : void
 * removeFirst() : E
 * removeLast() : E
 * toString() : String
 *
 * @version 03/07/2020
 */
public class DoublyLinkedList<E> {

    //---------------- Nested Node class ----------------

    private static class Node<E> {
        private E element;       // reference to the element stored at this node
        private Node<E> prev;    // reference to the previous node in the list
        private Node<E> next;    // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param p reference to a node that should precede the new node
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        // public accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that precedes this one (or null if no such node).
         *
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods

        /**
         * Sets the node's previous reference
         *
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            this.prev = p;
        }

        /**
         * Sets the node's next reference
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            this.next = n;
        }
    }

    //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    private Node<E> header;     // header sentinel
    private Node<E> trailer;    // trailer sentinel
    private int size;          // number of elements in the list

    /**
     * Constructor
     *
     * Constructs a new empty list.
     */
    public DoublyLinkedList() {
        this.header = new Node<>(null, null, null);     // create header
        this.trailer = new Node<>(null, header, null);     // trailer is preceded by header
        this.header.setNext(trailer);                           // header is followed by trailer
        this.size = 0;
    }

    // public accessor methods

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
     * Returns (but does not remove) the first element of the list.
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    // public update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty())
            return null;
        return remove(header.getNext());
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty())
            return null;
        return remove(trailer.getPrev());
    }

    /**
     * Adds an element to the linked list in between the given nodes.
     *
     * @param predecessor node just before the location where the new element is inserted
     * @param successor   node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     *
     * @param node the node to be removed.
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();
        lista.addFirst(1);
        lista.addFirst(3);
        lista.addFirst(5);
        lista.addFirst(7);
        lista.addFirst(9);
        lista.addFirst(4);
        lista.addLast(6);
        System.out.println(lista.toString()); // (4, 9, 7, 5, 3, 1, 6)
        System.out.println(lista.getSize()); // 7
        System.out.println(lista.isEmpty()); // false
        System.out.println(lista.first()); // 4
        System.out.println(lista.last()); // 6
        System.out.println(lista.removeFirst()); // 4
        System.out.println(lista.removeLast()); // 6
        System.out.println(lista.toString()); // (9, 7, 5, 3, 1)
        System.out.println(lista.remove(lista.header.getNext().getNext())); // 7
        System.out.println(lista.toString()); // (9, 5, 3, 1)
    }
} //----------- End of DoublyLinkedList class -----------
