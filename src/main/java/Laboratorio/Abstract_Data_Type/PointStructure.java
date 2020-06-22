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

  //  public double removeClosestTo(double x, double y) { }
}
