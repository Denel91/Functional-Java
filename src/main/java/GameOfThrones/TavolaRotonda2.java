package GameOfThrones;

import Liste.IntSList;

public class TavolaRotonda2 {

    private final IntSList cavalieri; // prima lista a sinistra
    private final IntSList seguito; // seconda lista a destra
    private final int num; // numero totale dei cavalieri

    public TavolaRotonda2(int n) {
        this.cavalieri = range(1, n);
        this.seguito = IntSList.NULL_INTLIST;
        this.num = n;
    }

    private TavolaRotonda2(IntSList cav, IntSList seg, int n) { // n > 0
        this.cavalieri = cav;
        this.seguito = seg;
        this.num = n;
    }

    public int numeroDiCavalieri() {
        return num;
    }

    public int cavConLaBrocca() {
        return cavalieri.car();
    }

    public TavolaRotonda2 dopoUscitaCav() {
        // lista di sinistra con un elemento in meno
        IntSList u = cavalieri.cdr();

        // lista di destra con un elemento in più
        IntSList v = seguito.cons(cavalieri.car());

        if (u.isNull()) {

            return new TavolaRotonda2(v.reverse().cdr(), IntSList.NULL_INTLIST, num - 1);

        } else if (u.cdr().isNull()) {

            return new TavolaRotonda2(v.reverse(), IntSList.NULL_INTLIST, num - 1);

        } else {

            return new TavolaRotonda2(u.cdr(), v, num - 1);
        }
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
}



