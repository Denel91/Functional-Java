package Laboratorio.Torri_di_Hanoi;

import java.util.ArrayList;

/**
 * Una torre contenente dischi nel rompicapo delle Torri di Hanoi
 */
public class Tower {
    // rappresentazione interna della Torre di Hanoi
    private ArrayList<Integer> disks;

    /**
     * Costruisce una torre con dischi di dimensione decrescente
     *
     * @param ndisks il numero di dischi
     */
    public Tower(int ndisks) {
        disks = new ArrayList<Integer>();
        for (int d = ndisks; d >= 1; d--) {
            disks.add(d);
        }
    }

    /**
     * Elimina da questa torre il disco che si trova in cima
     *
     * @return la dimensione del disco eliminato
     */
    public int remove() {
        return disks.remove(disks.size() - 1);
    }

    /**
     * Aggiunge un disco in cima a questa torre
     *
     * @param size la dimensione del disco da aggiungere
     */
    public void add(int size) {
        if (disks.size() > 0 && disks.get(disks.size() - 1) < size) {
            throw new IllegalStateException("Disk is too large");
        }
        disks.add(size);
    }

    @Override
    public String toString() {
        return disks.toString();
    }
}
