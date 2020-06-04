package Laboratorio.Abstract_Data_Type;

import java.util.Vector;

/**
 * Un’istanza della classe ProximityStructure consente di modellare una collezione di misure,
 * rappresentate da valori di tipo double, manipolabile attraverso il seguente protocollo:
 *
 * * Class overview:
 * new ProximityStructure()         // costruisce una collezione vuota di misure
 * s.size()                         // restituisce il numero di misure contenute nella collezione
 * s.add(x)                         // aggiunge la misura x alla collezione s
 * s.removeClosestTo(x)             // rimuove da s e restituisce la misura più prossima a x
 *                                  // (la cui distanza da x è più piccola) in s
 */
public class ProximityStructure {
    // rappresentazione interna: un vettore di misure di tipo Double
    private Vector<Double> collezione;

    /**
     * Constructor
     */
    public ProximityStructure() {
        collezione = new Vector<>();
    }

    /**
     * Restituisce il numero di elementi contenuti nel vettore
     *
     * @return il numero di misure contenute nella collezione
     */
    public int size() {
        return collezione.size();
    }

    /**
     * Aggiunge un nuovo elemento al vettore
     *
     * @param x la misura da aggiungere alla collezione
     */
    public void add(double x) {
        collezione.add(x);
    }

    /**
     * Rimuove dalla collezione la misura più prossima a x
     *
     * @param x una misura di tipo double
     * @return la misura più vicina a x
     */
    public double removeClosestTo(double x) { // la struttura non è vuota
        double y = collezione.get(0);
        int n = collezione.size();
        int k = 0;

        for (int i = 1; i < n; i++) {
            double z = collezione.get(i);
            if (Math.abs(z - x) < Math.abs(y - x)) {
                y = z;
                k = i;
            }
        }

        collezione.removeElementAt(k);
        return y;
    }

    @Override
    public String toString() {
        return collezione.toString();
    }

    public static void main(String[] args) {
        ProximityStructure p = new ProximityStructure();
        p.add(0.5);
        p.add(0.2);
        p.add(0.4);
        p.add(0.6);
        p.add(0.8);
        System.out.println(p.size());
        p.removeClosestTo(0.3);
        System.out.println(p);
    }
}
