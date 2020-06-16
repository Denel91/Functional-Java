package Laboratorio.Verifica_Correttezza;

public class Pow {

    public static int pow4(int n) { // Pre: n > 0
        int x = 0, y = 0;
        int z = 1, u = 1;

        while (x < u) {  // Inv: (x ≤ n^2) ∧ (y = x^2) ∧ (z = 2x+1) ∧ (u = min(y+z,n^2))
            x = x + 1;
            y = y + z;
            z = z + 2;

            if (x < n) { // x deve essere minore di n, così da poter aggiornare la variabile u correttamente.
                u = y + z;
            }
        }

        return y;  // Post: y = n^4
    }

    public static void main(String[] args) {
        System.out.println(pow4(2)); // 16
        System.out.println(pow4(3)); // 81
        System.out.println(pow4(4)); // 256
        System.out.println(pow4(5)); // 625
    }
}
