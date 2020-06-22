package Laboratorio.Dynamic_programming;

/**
 * Bottom-Up dynamic programming
 *
 * @version 30/04/2020
 */
public class DynamicFibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(8));
    }

    /**
     * Progressione di Fibonacci
     * Versione Bottom-Up dynamic programming
     *
     * @param n un Integers number
     * @return l'i-esimo valore di n
     */
    public static long fibonacci(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
} // class DynamicFibonacci
