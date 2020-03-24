package Liste;

/**
 * La classe rappresenta una lista di interi
 *
 * IntSList il = new IntSList(): Oggetto lista vuota    // null
 * il.isNull() : boolean                                // null?
 * il.car() : int                                       // car
 * il.cdr() : IntSList                                  // cdr
 * il.cons(n) : IntSList                                // cons
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
 * @version 24/03/2020
 */

public class IntSList {

    // variabili di istanza private
    private boolean empty;
    private int first;
    private IntSList rest;

    /**
     * Costruttore di istanza
     */
    public IntSList() {
        this.empty = true;
        this.first = 0;
        this.rest = null;
    }

    /**
     * Costruttore di istanza
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
     * @return true if IntSList is empty, false otherwise
     */
    public boolean isNull() {
        return empty;
    }

    /**
     * @return the first element of the IntSList
     */
    public int car() {
        return first;
    }

    /**
     * @return the IntSList without the first element
     */
    public IntSList cdr() {
        return rest;
    }

    /**
     * @param n an Integer value. REQUIRE not null
     * @return an IntSList starting from n in the first position
     */
    public IntSList cons(int n) {
        return new IntSList(n, this);
    }
} // class IntSList
