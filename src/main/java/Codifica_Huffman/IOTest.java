package Codifica_Huffman;

public class IOTest {
    public static void main(String[] args) {
      int value = IOFile.copyFile("FileInput.txt", "FileOutput.txt");
      System.out.println(value);
    }
}
