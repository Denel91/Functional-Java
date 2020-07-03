package Laboratorio.Abstract_Data_Type;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class NodeIntStack {
    private ArrayList<Node> stack;                  // the items of the stack
    private int capacity;                           // specifies the maximum capacity of the stack
    private int top;                                // the index of the item at the top of the stack
    private static final int DEFAULT_SIZE = 100;    // default stack size

    public NodeIntStack() {
        this(DEFAULT_SIZE);
    }

    public NodeIntStack(int capacity) {
        this.capacity = capacity == 0 ? DEFAULT_SIZE : capacity;
        this.top = -1; // Stack inizialmente vuoto
        this.stack = new ArrayList<>(capacity);
    }

    public boolean isEmpty() {
        return (this.stack.size() == 0);
    }

    public int size() {
        return this.stack.size();
    }

    public void push(Node n, int d) {
        if (size() == capacity)
            throw new IllegalStateException("Stack is full");
        stack.add(d, n);
        top++;
    }

    public void pop() {
        if (isEmpty())
            throw new EmptyStackException();
        stack.remove(top);
    }

    public Node topNode() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.get(top);
    }

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
    }
}
