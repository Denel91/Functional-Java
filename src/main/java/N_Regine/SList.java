package N_Regine;

/**
 * Definizione di una classe per realizzare oggetti
 * assimilabili alle liste in Scheme, in versione Generics
 * <p>
 * Le liste create sono "immutabili".
 * <p>
 * Class overview:
 * * SList() : Default Constructor
 * * SList(T f, SList<T> r) : Constructor
 * * isEmpty() : boolean
 * * car() : T
 * * cdr() : SList<T>
 * * cons(e) : SList<T>
 * * belong(T e) : boolean
 * * length() : int
 * * listRef(int index) : T
 * * equals(cl) : boolean
 * * append(ql) :SList<T>
 * * reverse() : SList<T>
 * * reverseRec(SList<T> rl) : SList<T>
 * * toString() : String
 *
 * @version 21/04/2020
 */
public class SList<T> {
    // Rappresentazione interna di una lista
    // variabili di istanza private immutabili
    private final boolean empty; // stato della lista
    private final T first; // Referenzia il primo elemento della lista
    private final SList<T> rest; // Contiene il resto della lista senza il primo elemento

    /**
     * Costruttore di istanza
     * <p>
     * Creazione di una lista vuota
     */
    public SList() {
        this.empty = true;
        this.first = null;
        this.rest  = null;
    }

    /**
     * Costruttore di istanza
     * Creazione di una lista non vuota
     *
     * @param f the first element of SList<T>
     * @param r the rest elements of SList<T>
     */
    public SList(T f, SList<T> r) {
        this.empty = false;
        this.first = f;
        this.rest  = r;
    }

    /**
     * Verifica se la lista è vuota
     *
     * @return true if SList<T> is empty, false otherwise
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Ritorna il primo elemento della lista
     *
     * @return the first element of SList<T>
     */
    public T car() {
        return first;
    }

    /**
     * Ritorna la lista tranne il primo elemento
     *
     * @return the SList<T> without the first element
     */
    public SList<T> cdr() {
        return rest;
    }

    /**
     * Costruisce una lista a partire dall'elemento e in prima posizione
     *
     * @param e a valid Object value.
     * @return a SList<T> starting from e in the first position
     */
    public SList<T> cons(T e) {
        return new SList<T>(e, this);
    }

    /**
     * Verifica se un elemento appartiene alla lista SList<T>
     *
     * @param e the element to verify
     * @return true if the element belong to SList<T>, false otherwise
     */
    public boolean belong(T e) {
        if (this.isEmpty()) {
            return false;
        } else if (this.car() == e) {
            return true;
        } else {
            return cdr().belong(e);
        }
    }

    /**
     * Calcola la lunghezza della lista SList<T>
     *
     * @return the length of SList<T>
     */
    public int length() {
        if (this.isEmpty()) {
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
    public T listRef(int index) {
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
    public boolean equals(SList<T> cl) {
        if (this.isEmpty()) {
            return cl.isEmpty();

        } else if (cl.isEmpty()) {
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
    public SList<T> append(SList<T> ql) {
        if (this.isEmpty()) {
            return ql;

        } else {
            return this.cdr().append(ql).cons(car());
        }
    }

    /**
     * Inverte gli elementi della lista SList<T>
     *
     * @return the list with inverted elements
     */
    public SList<T> reverse() {
        return reverseRec(new SList<T>());
    }

    /**
     * Metodo di supporto privato che inverte gli elementi della lista SList<T> rl
     *
     * @param rl the list to reverse
     * @return the list with inverted elements
     */
    private SList<T> reverseRec(SList<T> rl) {
        if (this.isEmpty()) {
            return rl;

        } else {
            return cdr().reverseRec(rl.cons(car()));
        }
    }

    /**
     * Visualizza la lista di Object
     *
     * @return the SList<T> in String format
     */
    @Override
    public String toString() {
        if (this.empty) {
            return "(---)";

        } else if (rest.isEmpty()) {
            return "(" + this.first + ")";

        } else {
            String elements = "(" + this.first;
            SList<T> restElements = this.rest;

            while (!restElements.isEmpty()) {
                elements += ", " + restElements.car();
                restElements = restElements.cdr();
            }

            return elements + ")";
        }
    }
} // class SList<T>
