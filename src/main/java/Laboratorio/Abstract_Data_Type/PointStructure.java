package Laboratorio.Abstract_Data_Type;

import java.util.Vector;

/**
 * Un’istanza della classe PointStructure consente di modellare una collezione di punti,
 * ciascuno rappresentato da una coppia di coordinate di tipo double, collezione accessibile
 * attraverso il seguente protocollo:
 *
 * * Class overview:
 * PointStructure() : Constructor        // costruisce una collezione vuota di punti.
 * s.size() : int                        // restituisce il numero di punti contenuti nella collezione s
 * s.add(x, y) : void                    // aggiunge il punto di coordinate (x,y) alla collezione
 * s.removeClosestTo(x, y) : double      // rimuove da s il punto più vicino a quello di coordinate (x,y) e ne restituisce la distanza
 *
 * @version 22/06/2020
 */
public class PointStructure {
    // rappresentazione interna
    private Vector<Double> collezione;

    public PointStructure() {
        collezione = new Vector<>();
    }

    public int size() {
        return collezione.size();
    }

    public void add(double x, double y) {
        collezione.add(x);
        collezione.add(y);
    }

    @Override
    public String toString() {
        return collezione.toString();
    }

    public double removeClosestTo(double x, double y) { // [2.0, 4.0, 1.0, 2.0, 5.0, 6.0]
        double pointX = collezione.get(0); // 2.0
        double pointY = collezione.get(1); // 4.0
        int n = collezione.size(); // 6
        int k = 0;
        int j = 0;

        for (int i = 2; i < n; i++) {
            double pointZ = collezione.get(i); // 1.0
            double pointW = collezione.get(++i); // 2.0

            if (Math.abs(pointZ - x) < Math.abs(pointX - x) && Math.abs(pointW - y) < Math.abs(pointY - y)) {
                pointX = pointZ;
                pointY = pointW;
                k = i;
                j = k + 1;
            }
        }

        collezione.removeElementAt(k);
        collezione.removeElementAt(j);

        return Math.abs(pointX - x) + Math.abs(pointY - y);
    }

    public static void main(String[] args) {
        PointStructure pointStructure = new PointStructure();
        pointStructure.add(2.0, 4.0);
        pointStructure.add(1.0, 2.0);
        pointStructure.add(5.0, 6.0);
        //System.out.println(pointStructure.removeClosestTo(1.1, 2.1));
        System.out.println(pointStructure);
    }
}
