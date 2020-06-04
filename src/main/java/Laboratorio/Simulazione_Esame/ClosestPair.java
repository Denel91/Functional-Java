package Laboratorio.Simulazione_Esame;

import java.util.Arrays;

/**
 * Function Description:
 * Complete the closestNumbers function.
 * It must return an array of integers as described.
 *
 * closestNumbers has the following parameter(s):
 * * arr: an array of integers
 */
public class ClosestPair {

    // closestPair(new double[] {0.3, 0.1, 0.6, 0.8, 0.5, 1.1}) -> {0.5, 0.6}

    //public static double[] closestPair(double[] arr) {}

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
            }
        }

        for (int i = arr.length - 2; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == minDiff) {
                lowestArray[n] = arr[i + 1];
                n++;
            }
        }

        return lowestArray;
    }

    public static void display(int[] v) {
        for (int i = 1; i < v.length; i++) {
            System.out.print("(" + v[i - 1] + ", " + v[i] + ")");
        }
    }

    public static void main(String[] args) {
        display(closestNumbers(new int[]{5, 4, 3, 2, 1}));
        System.out.println();
        display(closestNumbers(new int[]{6, 5, 4, 2, 0}));
        System.out.println();
        System.out.println(Arrays.toString(closestNumbers(new int[]{6, 5, 4, 2, 0})));
    }
}
