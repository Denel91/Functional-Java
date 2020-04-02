package GameOfThrones;

import Liste.IntSList;

/**
 * Costruttori per creare "nuove" situazioni:
 *
 * TavolaRotonda tr = new Tavola(n); // n > 0
 *
 * Metodi per acquisire informazioni sulla situazione modellata:
 *
 * tr.numerodiCavalieri() : int
 * tr.cavConLaBrocca() : int [etichetta, posizione]
 *
 * Metodi per generare una nuova situazione a partire da una situazione data:
 *
 * tr.dopoUscitaCav() : TavolaRotonda
 */

public class TavolaRotonda {

    private final int[] cavalieri;

    public TavolaRotonda(int n) { // n > 0
        cavalieri = new int[n];
        for (int k = 1; k <= n; k++) {
            cavalieri[k - 1] = k;
        }
    }

    private TavolaRotonda(int[] cav) {
        this.cavalieri = cav;
    }

    public int numeroDiCavalieri() {
        return cavalieri.length;
    }

    public int cavConLaBrocca() {
        return cavalieri[0];
    }

    public TavolaRotonda dopoUscitaCav() {
        int n = cavalieri.length - 1;
        int[] cav = new int[n];

        for (int i = 0; i < n - 1; i++) {
            cav[i] = cavalieri[i + 2];
        }

        cav[n - 1] = cavalieri[0];

        return new TavolaRotonda(cav);
    }

    /**
     * Crea una lista di interi a partire da m fino ad n
     *
     * @param m the first element of the IntSList. REQUIRE m < n
     * @param n the last element of the IntSList. REQUIRE n > m
     * @return the IntSList from m to n
     */
    private static IntSList range(int m, int n) {
        if (m > n) {
            return IntSList.NULL_INTLIST;
        } else {
            return range(m + 1, n).cons(m);
        }
    }
} // TavolaRotonda
