package Liste;

import java.util.Iterator;

/**
 * Definizione di una classe per realizzare oggetti
 * assimilabili alle liste in Scheme, limitatamente al caso
 * di liste di interi.
 *
 * Le liste create sono "immutabili".
 *
 * IntSList il = new IntSList(): Oggetto lista vuota    // null
 * il.isNull() : boolean                                // null?
 * il.car() : int                                       // car
 * il.cdr() : IntSList                                  // cdr
 * il.cons(n) : IntSList                                // cons
 * il.length() : int                                    // length
 * il.listRef(i) : int                                  // list-ref
 * il.equals(cl) : boolean                              // equal?
 * il.append(ql) : IntSList                             // append
 * il.reverse() : IntSList                              // reverse
 *
 * null:    Rappresenta la lista vuota
 * null?:   Verifica se la lista è vuota
 * car():   Ritorna il primo elemento della lista
 * cdr():   Ritorna la lista tranne il primo elemento
 * cons(n): Costruisce una lista a partire dall'elemento n in prima posizione
 *
 * ESEMPI:
 *
 * (new IntSList()).cons(5) --> (5)
 *
 * Oppure:
 * IntSList il = new IntSList();
 * il.isNull() --> true
 *
 * il = il.cons(5);
 * il.isNull() --> false
 *
 * il --> (5)
 *
 * il = il.cons(4);
 * il --> (4 5)
 *
 * @version 26/03/2020
 */

public class IntSList implements Iterable<Integer> {

    // Rappresentazione interna di una lista
    // variabili di istanza private immutabili
    private final boolean empty;
    private final int first;
    private final IntSList rest;
    // costante globale di classe
    public static final IntSList NULL_INTLIST = new IntSList();

    /**
     * Costruttore di istanza
     *
     * Creazione di una lista vuota
     */
    public IntSList() {
        this.empty = true;
        this.first = 0;
        this.rest = null;
    }

    /**
     * Costruttore di istanza
     *
     * Creazione di una lista non vuota
     *
     * @param f the first element of the IntSList
     * @param r the rest of the IntSList
     */
    public IntSList(int f, IntSList r) {
        this.empty = false;
        this.first = f;
        this.rest = r;
    }

    /**
     * Verifica se una lista è vuota
     *
     * @return true if IntSList is empty, false otherwise
     */
    public boolean isNull() {
        return empty;
    }

    /**
     * Ritorna il primo elemento della lista
     *
     * @return the first element of the IntSList
     */
    public int car() {
        return first;
    }

    /**
     * Ritorna la lista tranne il primo elemento
     *
     * @return the IntSList without the first element
     */
    public IntSList cdr() {
        return rest;
    }

    /**
     * Costruisce una lista a partire dall'elemento n in prima posizione
     *
     * @param n an Integer value. REQUIRE not null
     * @return an IntSList starting from n in the first position
     */
    public IntSList cons(int n) {
        return new IntSList(n, this);
    }

    /**
     * Calcola la lunghezza di IntSList
     *
     * @return the length of the List
     */
    public int length() {

        if (this.isNull()) {

            return 0;

        } else {

            return this.cdr().length() + 1;
        }
    }

    /**
     * Restituisce l'i-esimo elemento della lista
     *
     * @param index the index of the element within the list
     * @return the element searched if the index is between 0 and the length of the list
     */
    public int listRef(int index) {
        if (index == 0) {

            return car();

        } else {

            return cdr().listRef(index - 1);
        }
    }

    /**
     * Confronta se due liste sono uguali
     *
     * @param cl the list to compare
     * @return true if this and cl are equals, false otherwise
     */
    public boolean equals(IntSList cl) {
        if (this.isNull()) {

            return cl.isNull();

        } else if (cl.isNull()) {

            return false;

        } else if (car() == cl.car()) {

            return cdr().equals(cl.cdr());

        } else {

            return false;
        }
    }

    /**
     * Aggiunge in coda una nuova lista
     *
     * @param ql the list to add at the end of this
     * @return the complete list this with ql
     */
    public IntSList append(IntSList ql) {
        if (this.isNull()) {

            return ql;

        } else {

            return this.cdr().append(ql).cons(car());
        }
    }

    /**
     * Restituisce la lista con gli elementi invertiti
     *
     * @return the list with inverted elements
     */
    public IntSList reverse() {
        return reverseRec(NULL_INTLIST);
    }

    /**
     * Metodo di supporto privato che inverte gli elementi della lista rl
     *
     * @param rl the list to reverse
     * @return the list with inverted elements
     */
    private IntSList reverseRec(IntSList rl) {
        if (this.isNull()) {

            return rl;

        } else {

            return cdr().reverseRec(rl.cons(car()));
        }
    }

    /**
     * Visualizza la lista di Integer
     *
     * @return the IntSList in String format
     */
    @Override
    public String toString() {
        if (this.empty) {

            return "(---)";

        } else if (rest.isNull()) {

            return "(" + this.first + ")";

        } else {

            String elements = "(" + this.first;
            IntSList restElements = this.rest;

            while (!restElements.isNull()) {

                elements += ", " + restElements.car();
                restElements = restElements.cdr();
            }

            return elements + ")";
        }
    }

    /**
     * Visualizza la lista di interi
     *
     * @param sList la lista di interi da visualizzare
     */
    public void display(IntSList sList) {
        String s = "(";
        String t = ")";

        System.out.print(s);

        for (Integer el : sList) {

            if (el != listRef(length() - 1)) {

                System.out.print(el + ", ");

            } else {

                System.out.print(el);
            }
        }

        System.out.print(t);
    }

    /**
     * Iteratore: Permette di iterare sugli elementi della lista.
     *
     * @return the IntSList with the iterator() method
     */
    @Override
    public Iterator<Integer> iterator() {
        IntSList c = this;

        return new Iterator<Integer>() {
            private IntSList current = c;

            @Override
            public boolean hasNext() {
                return current != null && !current.isNull();
            }

            @Override
            public Integer next() {
                Integer i = current.first;
                current = current.rest;
                return i;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
} // class IntSList
