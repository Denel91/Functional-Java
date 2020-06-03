package Laboratorio.Simulazione_Esame;

public class SymmetricMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, -1, 5}, {-1, 2, 1}, {5, 1, 3}};

        int[][] matrix_2 = {{3, 1, 1}, {3, 4, 0}, {1, 4, 1}};

        System.out.println("The matrix is given below: ");
        display(matrix_2);

        System.out.println("\nThe transpose of the matrix is given below: ");
        display(trasposta(matrix_2));

        System.out.println("Is symmetric?: " + isSymmetric(matrix_2));

        System.out.println("Is symmetric?: " + isSymmetric(matrix));
    }

    /**
     * Verifica se la matrice m passata come parametro è simmetrica.
     *
     * @param m una matrice di Integer
     * @return true se e solo se la matrice m è simmetrica
     */
    public static boolean isSymmetric(int[][] m) {
        int[][] b = trasposta(m);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Restituisce la matrice trasposta della matrice m.
     *
     * @param m una matrice di Integer
     * @return la matrice trasposta di m.
     */
    public static int[][] trasposta(int[][] m) {
        int[][] b = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                b[i][j] = m[j][i];
            }
        }

        return b;
    }

    public static void display(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
