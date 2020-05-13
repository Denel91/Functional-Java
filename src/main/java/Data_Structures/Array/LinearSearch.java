package Data_Structures.Array;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] values = {2, 5, 8, 1, 10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] vec = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        ricercaLineare(values, 33); // 7
        boolean res = isSorted(values);
        boolean response = isSorted(vec);
        System.out.println(res); // false
        System.out.println(response); // true
        Arrays.sort(values);
        System.out.println(Arrays.toString(values)); // [1, 2, 5, 8, 9, 10, 21, 22, 33, 41, 50, 60, 80]
        System.out.println(Arrays.toString(vec)); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30]
        ricercaLineare(values, 33); // 8
    }

    /**
     * Ricerca lineare
     *
     * @param array  un array di Integers
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

    public static boolean isSorted(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] > vector[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
