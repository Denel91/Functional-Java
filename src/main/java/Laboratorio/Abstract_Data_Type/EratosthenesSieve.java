package Laboratorio.Abstract_Data_Type;

import java.util.Arrays;

/**
 * Crivello di Eratostene
 */
public class EratosthenesSieve {
    private boolean[] sieve;
    private int size;

    public EratosthenesSieve(int n) {
        this.sieve = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }

        this.size = n;
    }

    public boolean isInSieve(int p) {
        return sieve[p];
    }

    public void removeMultiplesOf(int p) {
        for (int k = 2 * p; k <= size; k = k + p) {
            sieve[k] = false;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(sieve);
    }

    public static void main(String[] args) {
        EratosthenesSieve eratosthenesSieve = new EratosthenesSieve(20);
        eratosthenesSieve.removeMultiplesOf(2);
        System.out.println(eratosthenesSieve.toString());
        System.out.println(eratosthenesSieve.isInSieve(8));
    }
}
