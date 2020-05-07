package Codifica_Huffman;

public class IOTest {
    public static void main(String[] args) {
      int value =  IOFile.copyFile("IOFile", "FileOutput");
      System.out.println(value);
    }
}
