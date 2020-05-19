package Codifica_Huffman;

/**
 * Classe Frame
 *
 * * Class overview:
 * Frame(Node n, String p) : Constructor
 *
 * @version 19/05/2020
 */
public class Frame {

    // variabili private di istanza
    public final Node node;
    public final String pre;

    public Frame(Node n, String p) {
        this.node = n;
        this.pre  = p;
    }
}
