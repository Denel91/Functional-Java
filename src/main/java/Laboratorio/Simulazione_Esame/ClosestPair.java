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

        // Sort array elements
        Arrays.sort(arr);

        // distanza tra il primo e il secondo elemento dell'array
        int minDiff = (arr[1] - arr[0]);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentMin = Math.abs(arr[j] - arr[i]);
                if (currentMin < minDiff) {
                    minDiff = currentMin;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == minDiff) {
                lowestArray[i - 1] = arr[i - 1];
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
        // display(closestNumbers(new int[]{5, 4, 3, 2, 1}));
        System.out.println(Arrays.toString(closestNumbers(new int[]{5, 4, 3, 2, 1})));
    }
}
