package Codifica_Huffman;

import huffman_toolkit.InputTextFile;
import huffman_toolkit.OutputTextFile;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Huffman {
    // costante di classe immutabile
    private static final int CHARS = InputTextFile.CHARS;

    public static int[] freqHistogram(String src) {
        int[] frequenze = new int[CHARS];

        for (int i = 0; i < CHARS; i++) {   // setto a 0 tutti gli elementi dell'array
            frequenze[i] = 0;
        }

        InputTextFile in = new InputTextFile(src);

        while (in.textAvailable()) {
            char c = in.readChar();
            frequenze[c] += 1;
        }

        in.close();

        return frequenze;
    }

    public static Node huffmanTree(int[] freq) {
        PriorityQueue<Node> q = new PriorityQueue<>();

        for (int i = 0; i < CHARS; i++) {
            if (freq[i] > 0) {
                Node n = new Node((char) i, freq[i]);
                q.add(n);
            }
        }

        while (q.size() > 1) {      // alla fine del ciclo, la coda sarà di un solo elemento
            Node l = q.poll();      // toglie l'elemento con peso minore
            Node r = q.poll();      // la coda si accorcia di uno
            Node n = new Node(l, r);
            q.add(n);
        }

        return q.poll();
    }

    /*
    public static String[] codeTable(Node root) {
        String[] codes = new String[CHARS];
        fillTable(root,"", codes);
        return codes;
    }
     */

    private static void fillTable(Node n, String pre, String[] codes) {
        if (n.isLeaf()) {
            char c = n.character();
            codes[c] = pre;

        } else {
            fillTable(n.left(), pre + "0", codes);
            fillTable(n.right(), pre + "1", codes);
        }
    }

    /*
    public static String flattenTree(Node n) {
        if (n.isLeaf()) {
            char c = n.character();
            if (c == '@' || c == '\\') {
                return "\\" + c;

            } else {
                return "" + c;
            }

        } else {
            return "@" + flattenTree(n.left()) + flattenTree(n.right());
        }
    }
     */

    public static void compresso(String src, String dst) {
        int[] freq = freqHistogram(src);
        Node root = huffmanTree(freq);
        String[] codes = codeTable(root);

        // Intestazione:
        int size = root.weight();       // dimensione
        String ht = flattenTree(root);  // codifica
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        out.writeTextLine("" + size);
        out.writeTextLine(ht);

        for (int i = 0; i < size; i++) {
            char c = in.readChar();
            out.writeCode(codes[c]);
        }

        in.close();
        out.close();
    }

    public static Node restoreTree(InputTextFile in) {
        char c = in.readChar();

        if (c == '@') {
            Node lft = restoreTree(in);
            Node rgt = restoreTree(in);
            return new Node(lft, rgt);

        } else {
            if (c == '\\') {
                c = in.readChar();
            }

            return new Node(c, 0);
        }
    }

    public static void decompress(String src, String dst) {
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);

        int size = Integer.parseInt(in.readTextLine());
        Node root = restoreTree(in);
        String skip = in.readTextLine(); // salta capolinea

        for (int i = 0; i < size; i++) {
            char c = restoreChar(root, in);
            out.writeChar(c);
        }

        in.close();
        out.close();
    }

    private static char restoreChar(Node n, InputTextFile in) {
        while (!n.isLeaf()) {

            int bit = in.readBit();
            if (bit == 0) {
                n = n.left();

            } else {
                n = n.right();
            }
        }

        return n.character();
    }

    public static String flattenTree(Node root) {
        String ht = "";
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node n = stack.pop();
            if (n.isLeaf()) {
                char c = n.character();
                if (c == '@' || c == '\\') {
                    ht = ht + "\\" + c;

                } else {
                    ht = ht + c;
                }

            } else {
                ht = ht + "@";
                stack.push(n.right());
                stack.push(n.left());
            }
        }

        return ht;
    }

    public static String[] codeTable(Node root) {
        String[] codes = new String[CHARS];
        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(root, ""));

        while (!stack.isEmpty()) {
            Frame f = stack.pop();
            Node n = f.node;
            String pre = f.pre;

            if (n.isLeaf()) {
                char c = n.character();
                codes[c] = pre;

            } else {
                stack.push(new Frame(n.right(), pre + "1"));
                stack.push(new Frame(n.left(), pre + "0"));
            }
        }

        return codes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(freqHistogram("InputFile.txt")));
        System.out.println(flattenTree(huffmanTree(freqHistogram("InputFile.txt"))));
        compresso("InputFile.txt", "OutputFile.txt");
        // (char) ((int) (Math.random * 128)) --> tra 0 e 128 escluso
    }
}
