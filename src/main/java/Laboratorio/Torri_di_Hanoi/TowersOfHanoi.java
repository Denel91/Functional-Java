package Laboratorio.Torri_di_Hanoi;

public class TowersOfHanoi {
    public static void main(String[] args) {
        move(5, 1, 3);
    }

    /**
     * Visualizza istruzioni per spostare una pila di dischi da un piolo ad un altro
     *
     * @param disk il numero di dischi da spostare
     * @param from il piolo da cui spostare i dischi
     * @param to   il piolo verso cui spostare i dischi
     */
    public static void move(int disk, int from, int to) {

        if (disk > 0) {
            int other = 6 - from - to;
            move(disk - 1, from, other);
            System.out.println("Move disk from peg " + from + " to " + to);
            move(disk - 1, other, to);
        }
    }
}
