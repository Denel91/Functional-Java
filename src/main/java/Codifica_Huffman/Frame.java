package Codifica_Huffman;

/**
 * Classe Frame
 */
public class Frame {

    public final Node node;
    public final String pre;

    public Frame(Node n, String p) {
        this.node = n;
        this.pre = p;
    }
}
