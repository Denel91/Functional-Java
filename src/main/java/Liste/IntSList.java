package Liste;

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

    // Rappresentazione interna di una lista
    // variabili di istanza private
    private boolean empty;
    private int first;
    private IntSList rest;

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
} // class IntSList
