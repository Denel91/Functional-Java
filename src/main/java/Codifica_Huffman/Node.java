package Codifica_Huffman;

/**
 * Data type for Node
 *
 * * Class overview:
 * Node(char chr, int wgt) : Constructor
 * Node(Node lft, Node rgt) : Constructor
 * isLeaf() : boolean
 * character() : char
 * weight() : int
 * left() : Node
 * right() : Node
 * compareTo(Node n) : int
 * toString() : String
 *
 * @version 19/05/2020
 */
public class Node implements Comparable<Node> {
    // variabili di istanza
    private final char character;
    private final int weight;
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
        this.weight = lft.weight() + rgt.weight();
        this.left = lft;
        this.right = rgt;
    }

    public boolean isLeaf() {
        return (left == null);
    }

    public char character() {
        return character;
    }

    public int weight() {
        return weight;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    @Override
    public int compareTo(Node n) {
        if (weight < n.weight()) {
            return -1;

        } else if (weight == n.weight()) {
            return 0;

        } else { // weight > n.weight()
            return 1;
        }
    }

    @Override
    public String toString() {
        return "weight = " + weight;
    }
} // class Node
