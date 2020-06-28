package Laboratorio.SchemeList;

/**
 * La classe IntList consente di modellare in Java strutture dati corrispondenti a liste di interi in Scheme.
 * Gli oggetti immutabili di tipo IntList rappresentano liste vuote o coppie “car/cdr”, in modo sostanzialmente
 * analogo a quanto avviene in Scheme.
 *
 * Class overview:
 * IntList() : Constructor
 * IntList(int n, IntList u) : Constructor
 * isEmpty() : boolean
 * car() : int
 * cdr() : IntList
 * length() : int
 * append(IntList v) : IntList
 *
 * @version 28/06/2020
 */
public class IntList {
    // Rappresentazione interna di una lista
    // variabili di istanza private immutabili
    private boolean empty;    // true se IntList è vuota, altrimenti false
    private int first;        // Referenzia il primo elemento della lista
    private IntList rest;     // Contiene il resto della lista senza il primo elemento
    // costante globale di classe
    public static final IntList NULL_INTLIST = new IntList();

    /**
     * Costruttore di default
     *
     * Crea una lista vuota
     */
    public IntList() {
        this.empty = true;
        this.first = 0;
        this.rest = null;
    }

    /**
     * Costruttore di istanza
     *
     * @param n il primo elemento di IntList
     * @param u il resto degli elementi di IntList
     */
    public IntList(int n, IntList u) {
        this.empty = false;
        this.first = n;
        this.rest = u;
    }

    /**
     * Verifica se la lista è vuota
     *
     * @return true if IntList is empty, false otherwise
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Ritorna il primo elemento della lista
     *
     * @return the first element of IntList
     */
    public int car() {
        return first;
    }

    /**
     * Ritorna la lista senza il primo elemento
     *
     * @return the IntList without the first element
     */
    public IntList cdr() {
        return rest;
    }

    /**
     * Calcola la lunghezza di IntList
     *
     * @return the length of IntList
     */
    public int length() {
        if (isEmpty())
            return 0;
        return this.cdr().length() + 1;
    }

    /**
     * Aggiunge in coda una nuova lista
     *
     * @param v the list to add at the end of this
     * @return the complete list this with v
     */
    public IntList append(IntList v) {
        if (isEmpty())
            return v;
        return new IntList(car(), cdr().append(v));
    }

    /**
     * Visualizza la lista di Integer
     *
     * @return the IntList in String format
     */
    @Override
    public String toString() {
        if (this.empty) {
            return "(---)";

        } else if (rest.isEmpty()) {
            return "(" + this.first + ")";

        } else {
            String elements = "(" + this.first;
            IntList restElements = this.rest;

            while (!restElements.isEmpty()) {
                elements += ", " + restElements.car();
                restElements = restElements.cdr();
            }

            return elements + ")";
        }
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        list = new IntList(4, list);
        list = new IntList(8, list);
        list = new IntList(6, list);
        list = new IntList(9, list);
        list = new IntList(3, list);
        list = new IntList(5, list);
        System.out.println(list.toString()); // (5, 3, 9, 6, 8, 4)
        System.out.println(list.length()); // 6
        System.out.println(list.isEmpty()); // false
        System.out.println(list.car()); // 5
        System.out.println(list.cdr()); // (3, 9, 6, 8, 4)
    }
}

