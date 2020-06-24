package Laboratorio.Torri_di_Hanoi;

import java.util.Arrays;

/**
 * Classe Towers_Of_Hanoi con tre torri
 */
public class Towers_Of_Hanoi {
    private Tower[] towers;

    /**
     * Crea una struttura in cui la prima torre ha un determinato numero di dischi.
     *
     * @param ndisks il numero di dischi
     */
    public Towers_Of_Hanoi(int ndisks) {
        towers = new Tower[3];
        towers[0] = new Tower(ndisks);
        towers[1] = new Tower(0);
        towers[2] = new Tower(0);
    }

    /**
     * Sposta una pila di dischi da un piolo all'altro e visualizza il movimento.
     *
     * @param disks il numero di dischi da spostare
     * @param from il piolo da cui spostare i dischi
     * @param to il piolo su cui spostare i dischi
     */
    public void move(int disks, int from, int to) {
        if (disks > 0) {
            int peg = 3 - from - to;
            move(disks - 1, from, peg);
            towers[to].add(towers[from].remove());
            System.out.println(Arrays.toString(towers));
            move(disks - 1, peg, to);
        }
    }
}
