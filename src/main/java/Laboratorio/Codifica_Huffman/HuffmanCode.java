package Laboratorio.Codifica_Huffman;

import huffman_toolkit.*;
import Codifica_Huffman.Node;

import static Codifica_Huffman.Huffman.*;

public class HuffmanCode {

    private static final int CHARS = InputTextFile.CHARS;

    public static void main(String[] args) {
        codificaHuffman("InputFile.txt", "OutputFile.txt");
    }

    public static void codificaHuffman(String src, String dst) {
        int[] freq = freqHistogram(src);
        Node root = huffmanTree(freq);
        String[] codes = codeTable(root);

        OutputTextFile out = new OutputTextFile(dst);

        out.writeTextLine("CODICE ASCII" + "   " + "CARATTERE" + "   " + "OCCORRENZE" + "   " + "CODICE HUFFMANN" + "   " + "LUNGHEZZA CODICE");

        for (int i = 0; i < CHARS; i++) {
            if (freq[i] > 0) {
                String codice = codes[i];
                int lunghezza = codice.length();
                out.writeTextLine("    " + i + "          " + ((char) i) + "          " + freq[i] + "          " + codes[i] + "          " + lunghezza);
            }
        }

        out.close();
    }
}
