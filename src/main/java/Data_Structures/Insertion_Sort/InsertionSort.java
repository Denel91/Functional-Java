package Data_Structures.Insertion_Sort;

import java.util.Arrays;

/**
 * InsertionSort
 */
public class InsertionSort {

    /**
     * Ordinamento crescente di un array di interi per inserimento
     *
     * @param data the array of Integers
     */
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) { // inizia dal secondo elemento
            int cur = data[k];
            int j = k;
            // verifico se l'elemento precedente è maggiore dell'elemento corrente
            // e in caso positivo eseguo il corpo del ciclo while.
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1]; // fai scorrere data[j - 1] verso destra e considera il j precedente per cur
                j--;
            }

            data[j] = cur; // questo è il posto corretto per cur
        }
    }

    public static void main(String[] args) {
        int[] value = {0, 1, 2, 3, 4, 5, 7, 6, 9, 8, 10};
        System.out.println(Arrays.toString(value));
        insertionSort(value);
        System.out.println(Arrays.toString(value));
    }
}
