package Data_Structures.Array;

import java.util.Arrays;
public class LinearSearch {
    public static void main(String[] args) {
        int[] values = {2, 5, 8, 1, 10, 22, 9, 33, 21, 50, 41, 60, 80};
        ricercaLineare(values, 33); // 7
        Arrays.sort(values);
        System.out.println(Arrays.toString(values)); // [1, 2, 5, 8, 9, 10, 21, 22, 33, 41, 50, 60, 80]
        ricercaLineare(values, 33); // 8
    }

    /**
     * Ricerca lineare
     *
     * @param array un array di Integers
     * @param chiave l'elemento da cercare nell'array
     * @return l'indice di posizione dell'elemento
     */
    public static int ricercaLineare(int[] array, int chiave) {
        int searchedValue = chiave;
        int pos = 0;
        boolean found = false;
        while (pos < array.length && !found) {
            if (array[pos] == searchedValue) {
                found = true;

            } else {
                pos++;
            }
        }

        if (found) {
            System.out.println("Found at position: " + pos);

        } else {
            System.out.println("Not Found");
        }

        return pos;
    }
}
