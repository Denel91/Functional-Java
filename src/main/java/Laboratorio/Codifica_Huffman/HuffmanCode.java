package Laboratorio.Codifica_Huffman;

import huffman_toolkit.*;
import Codifica_Huffman.Node;
import static Codifica_Huffman.Huffman.*;

public class HuffmanCode {

    private static final int CHARS = InputTextFile.CHARS;

    public static void main(String[] args) {
        codificaHuffman("InputFile.txt", "OutputFile.txt");
    }

    /**
     * @param src il file sorgente
     * @param dst il file destinazione
     */
    public static void codificaHuffman(String src, String dst) {
        int[] freq = freqHistogram(src);
        Node root = huffmanTree(freq);
        String[] codes = codeTable(root);

        OutputTextFile out = new OutputTextFile(dst);

        out.writeTextLine("CODICE ASCII" + "\t" + "CARATTERE" + "\t" + "OCCORRENZE" + "\t" + "CODICE HUFFMANN" + "\t" + "LUNGHEZZA CODICE");

        for (int i = 0; i < CHARS; i++) {
            if (freq[i] > 0) {
                String codice = codes[i];
                int lunghezza = codice.length();
                out.writeTextLine("\t" + i + "\t\t\t" + ((char) i) + "\t\t\t\t" + freq[i] + "\t\t\t\t" + codes[i] + "\t\t\t\t" + lunghezza);
            }
        }

        out.close();
    }
}
