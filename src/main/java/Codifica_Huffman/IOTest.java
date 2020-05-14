package Codifica_Huffman;

public class IOTest {
    public static void main(String[] args) {
      int value = IOFile.copyFile("InputFile.txt", "Out.txt");
      System.out.println(value);
    }
}
