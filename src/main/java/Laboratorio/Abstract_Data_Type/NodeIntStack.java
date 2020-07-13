package Laboratorio.Abstract_Data_Type;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Una istanza della classe NodeIntStack consente di istanziare uno stack in cui possono essere inserite coppie <nodo, intero>.
 *
 * Class overview:
 * NodeIntStack() : Default Constructor
 * NodeIntStack(int capacity) : Constructor (Creator).
 * isEmpty() : boolean
 * size() : int
 * push(Node n, int d) : void
 * pop() : void
 * topNode() : Node
 * topInt() : int
 * toString() : String
 *
 * @version 03/07/2020
 */
public class NodeIntStack {
    private ArrayList<Node> stack;                  // the items of the stack
    private int capacity;                           // specifies the maximum capacity of the stack
    private int top;                                // the index of the item at the top of the stack
    private static final int DEFAULT_SIZE = 100;    // default stack size

    /**
     * Default Constructor
     */
    public NodeIntStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor (Creator).
     *
     * @param capacity the size of the stack. REQUIRE >= 0
     */
    public NodeIntStack(int capacity) {
        this.capacity = capacity == 0 ? DEFAULT_SIZE : capacity;
        this.top = -1; // Stack inizialmente vuoto
        this.stack = new ArrayList<>(capacity);
    }

    /**
     * Verify if the stack is empty
     *
     * @return true if this stack contains no elements.
     */
    public boolean isEmpty() {
        return (this.stack.size() == 0);
    }

    /**
     * Calculate the stack size
     *
     * @return the size of the stack
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * Insert the item on top of the stack
     *
     * @param n the item to insert in the stack
     * @param d the index where insert the item
     */
    public void push(Node n, int d) {
        if (size() == capacity)
            throw new IllegalStateException("Stack is full");
        stack.add(d, n);
        top++;
    }

    /**
     * Delete the item located at the top of the stack
     */
    public void pop() {
        if (isEmpty())
            throw new EmptyStackException();
        stack.remove(top);
    }

    /**
     * Fetch the first element of the Stack or the element
     * present at the top of the Stack.
     *
     * @return the object on top of the stack without taking it out
     */
    public Node topNode() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.get(top);
    }

    /**
     * Fetch the index of the element at the top of the Stack.
     *
     * @return the index at the top of the Stack.
     */
    public int topInt() {
        if (isEmpty())
            throw new EmptyStackException();
        return top;
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    //------------ classe annidata Node ------------ //

    private static class Node implements Comparable<Node> {
        // variabili di istanza
        private char character;
        private int weight;
        private final Node left;
        private final Node right;

        public Node(char chr, int wgt) {
            this.character = chr;
            this.weight = wgt;
            this.left = null;
            this.right = null;
        }

        public Node(Node lft, Node rgt) {
            this.character = (char) 0;
            this.weight = lft.getWeight() + rgt.getWeight();
            this.left = lft;
            this.right = rgt;
        }

        public char getCharacter() {
            return character;
        }

        public int getWeight() {
            return weight;
        }

        public boolean isLeaf() {
            return (left == null);
        }

        public Node left() {
            return left;
        }

        public Node right() {
            return right;
        }

        public void setKey(char key) {
            character = key;
        }

        private void setValue(int value) {
            weight = value;
        }

        @Override
        public int compareTo(Node n) {
            if (weight < n.getWeight()) {
                return -1;
            } else if (weight == n.getWeight()) {
                return 0;
            } else { // weight > n.weight()
                return 1;
            }
        }

        @Override
        public String toString() {
            return "(" + weight + "," + character + ")";
        }
    }

    //------------ Fine classe annidata Node ------------ //

    public static void main(String[] args) {
        NodeIntStack stack = new NodeIntStack();
        Node a = new Node('A', 5);
        Node b = new Node('B', 8);
        Node c = new Node('C', 4);
        Node d = new Node('D', 7);
        stack.push(a, 0);
        stack.push(b, 1);
        stack.push(c, 2);
        stack.push(d, 3);
        System.out.println(stack); // [(5,A), (8,B), (4,C), (7,D)]
        System.out.println(stack.size()); // 4
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.topNode()); // (7,D)
        System.out.println(stack.topInt()); // 3
        System.out.println(averageCodeLength(d));
        System.out.println(shortestCodeLength(d));
    }

    public static double averageCodeLength(Node root) {
        int ws = 0;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(0);

        do {
            Node n = stack.pop();
            int d = depth.pop();

            if (n.isLeaf()) {
                ws = ws + d * n.getWeight();

            } else {
                stack.push(n.right());
                depth.push(d + 1);
                stack.push(n.left());
                depth.push(d + 1);
            }

        } while (!stack.isEmpty());

        return ((double) ws) / root.getWeight();
    }

    public static int shortestCodeLength(Node root) {
        int sc = 8;
        NodeIntStack stack = new NodeIntStack();
        stack.push(root, 0);
        do {
            Node n = stack.topNode();
            int d = stack.topInt();
            stack.pop();
            if (n.isLeaf()) {
                sc = Math.min(sc, d);
            } else if (d + 1 < sc) {
                stack.push(n.right, d + 1);
                stack.push(n.left, d + 1);
            }
        } while (!stack.isEmpty());

        return sc;
    }
}
