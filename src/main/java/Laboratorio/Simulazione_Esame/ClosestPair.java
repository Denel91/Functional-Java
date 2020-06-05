package Laboratorio.Simulazione_Esame;

import java.util.Arrays;

/**
 * Function Description:
 * Complete the closestNumbers function.
 * It must return an array of integers as described.
 *
 * closestNumbers has the following parameter(s):
 * * arr: an array of integers
 *
 * closestPair(new double[] {0.3, 0.1, 0.6, 0.8, 0.5, 1.1}) -> {0.5, 0.6}
 *
 * @version 05/06/2020
 */
public class ClosestPair {

    public static double[] closestPair(double[] arr) {
        // array di supporto dove inserire le coppie che hanno la distanza più piccola
        double[] lowArray = new double[arr.length];
        int m = 0;
        int len = arr.length;

        // Se l'array in ingresso ha meno di due elementi restituisce l'array stesso
        if (len <= 2) {
            return arr;
        }

        // Sort array elements
        Arrays.sort(arr); // [0.1, 0.2, 0.3, 0.4, 0.5, 0.6]

        // distanza tra il primo e il secondo elemento dell'array
        // suppongo che questa sia la distanza minima
        double minDiff = Math.abs(arr[1] - arr[0]); // 0.1

        for (int i = 1; i < arr.length; i++) {
            double currentMin = Math.abs(arr[i] - arr[i - 1]);
            // 1 -> 0.2 - 0.1 = 0.1
            // 2 -> 0.3 - 0.2 = 0.09999999999999998 V
            // 3 -> 0.4 - 0.3 = 0.10000000000000003
            // 4 -> 0.5 - 0.4 = 0.09999999999999998 V
            // 5 -> 0.6 - 0.5 = 0.09999999999999998 V
            if (currentMin < minDiff) {
                minDiff = currentMin; // 0.09999999999999998
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == minDiff) {
                lowArray[m] = arr[i - 1];
                m++;
                lowArray[m] = arr[i];
                m++;
            }
        }

        return lowArray; // [0.2, 0.3, 0.4, 0.5, 0.5, 0.6]
    }

    /***********************************************************/

    public static int[] closestNumbers(int[] arr) {
        int[] lowestArray = new int[arr.length];
        int n = 0;
        int length = arr.length;

        if (length <= 2) {
            return arr;
        }

        // Sort array elements
        Arrays.sort(arr);

        // distanza tra il primo e il secondo elemento dell'array
        int minDiff = Math.abs(arr[1] - arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int currentMin = Math.abs(arr[i] - arr[i - 1]);
            if (currentMin < minDiff) {
                minDiff = currentMin;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == minDiff) {
                lowestArray[n] = arr[i];
                n++;
                lowestArray[n] = arr[i + 1];
                n++;
            }
        }

        return lowestArray;
    }

    // To Do -> Da rivedere nel caso degli Integer
    public static void display(int[] v) {
        for (int i = 1; i < v.length; i++) {
            System.out.print("(" + v[i - 1] + ", " + v[i] + ")");
        }
    }

    public static void display(double[] v) {
        for (int i = 0; i < v.length; i = i + 2) {
            if (v[i] != 0.0) {
                System.out.print("(" + v[i] + ", " + v[i + 1] + ")");
            }
        }
    }

    public static void main(String[] args) {
        display(closestPair(new double[]{0.3, 0.1, 0.6, 0.8, 0.5, 1.1}));
        System.out.println();

        display(closestPair(new double[]{0.2, 0.1, 0.4, 0.3, 0.5, 0.6}));
        System.out.println();

        System.out.println(Arrays.toString(closestPair(new double[]{0.2, 0.1, 0.4, 0.3, 0.5, 0.6})));
    }
}
