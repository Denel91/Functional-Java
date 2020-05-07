package Codifica_Huffman;

import huffman_toolkit.InputTextFile;
import huffman_toolkit.OutputTextFile;

/**
 * class IOFile
 */
public class IOFile {

    /**
     * Copia il contenuto del file src nel file dst
     *
     * @param src file sorgente
     * @param dst file destinazione
     * @return the lines's number in dst
     */
    public static int copyFile(String src, String dst) {
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        int count = 0;

        while (in.bitsAvailable()) {
            //String line = in.readTextLine();
            //out.writeTextLine(line);
            //char c = in.readChar();
            //out.writeChar(c);
            int bit = in.readBit();
            out.writeBit(bit);
            count += 1;
        }

        in.close();
        out.close();

        return count;
    }
}
