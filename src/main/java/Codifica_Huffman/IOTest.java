package Codifica_Huffman;

public class IOTest {
    public static void main(String[] args) {
      int value = IOFile.copyFile("LICENSE.md", "OutputFile.txt");
      System.out.println(value);
    }
}
