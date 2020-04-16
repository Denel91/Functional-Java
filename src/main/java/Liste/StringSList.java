package Liste;

import java.util.Iterator;

/**
 * Definizione di una classe per realizzare oggetti
 * assimilabili alle liste in Scheme, limitatamente al caso
 * di liste di stringhe.
 *
 * Le liste create sono "immutabili".
 *
 * Class overview:
 * StringSList() : Default Constructor
 * StringSList(String s, StringSList sl) : Constructor
 * isEmpty() : boolean
 * car() : String
 * cdr() : StringSList
 * cons(String s) : StringSList
 * length() : int
 * listRef(int index) : String
 * equals(StringSList sList) : boolean
 * append(StringSList list) : StringSList
 * reverse() : StringSList
 * toString() : String
 * display(StringSList sList) : void
 * iterator() : Iterator<String>
 *
 * @version 05/04/2020
 */

public class StringSList implements Iterable<String> {

    // costante globale di classe (condivisa)
    public static final StringSList NULL_STRINGLIST = new StringSList();
    // Rappresentazione interna di una lista di stringhe
    // variabili di istanza private immutabili
    private final boolean empty;
    private final String firstElement; // Referenzia il primo elemento della lista
    private final StringSList restElements; // Contiene il resto della lista senza il primo elemento

    /**
     * Costruttore di istanza
     *
     * Creazione di una lista vuota
     */
    public StringSList() {
        this.empty = true;
        this.firstElement = null;
        this.restElements = null;
    }

    /**
     * Costruttore di istanza
     * Creazione di una lista non vuota
     *
     * @param s  the first element of the StringSList
     * @param sl the rest of the StringSList
     */
    public StringSList(String s, StringSList sl) {
        this.empty = false;
        this.firstElement = s;
        this.restElements = sl;
    }

    /**
     * Verifica se una lista è vuota
     *
     * @return true if StringSList is empty, false otherwise
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Ritorna il primo elemento della lista
     *
     * @return the first element of the StringSList
     */
    public String car() {
        return firstElement;
    }

    /**
     * Ritorna la lista tranne il primo elemento
     *
     * @return the StringSList without the first element
     */
    public StringSList cdr() {
        return restElements;
    }

    /**
     * Costruisce una lista a partire dall'elemento s in prima posizione
     *
     * @param s a String value. REQUIRE not null
     * @return an StringSList starting from s in the first position
     */
    public StringSList cons(String s) {
        return new StringSList(s, this);
    }

    /**
     * Calcola la lunghezza di StringSList
     *
     * @return the length of the List
     */
    public int length() {
        if (this.isEmpty())
            return 0;
        else
            return this.cdr().length() + 1;
    }

    /**
     * Restituisce l'i-esimo elemento della lista
     *
     * @param index the index of the element within the list
     * @return the String searched if the index is between 0 and the length of the list
     */
    public String listRef(int index) {
        if (index == 0)
            return car();
        else
            return cdr().listRef(index - 1);
    }

    /**
     * Confronta se due liste sono uguali
     *
     * @param sList the list to compare
     * @return true if this and sList are equals, false otherwise
     */
    public boolean equals(StringSList sList) {
        if (this.isEmpty())
            return sList.isEmpty();

        else if (sList.isEmpty())
            return false;

        else if (car().equals(sList.car()))
            return this.cdr().equals(sList.cdr());

        else
            return false;
    }

    /**
     * Aggiunge in coda una nuova lista
     *
     * @param list the list to add at the end of this
     * @return the complete StringSList with list
     */
    public StringSList append(StringSList list) {
        if (this.isEmpty())
            return list;
        else
            return this.cdr().append(list).cons(car());
    }

    /**
     * Restituisce la lista con gli elementi invertiti
     *
     * @return the list with inverted elements
     */
    public StringSList reverse() {
        return reverseRec(NULL_STRINGLIST);
    }

    /**
     * Metodo di supporto privato che inverte gli elementi della lista rl
     *
     * @param rl the list to reverse
     * @return the list with inverted elements
     */
    private StringSList reverseRec(StringSList rl) {
        if (this.isEmpty())
            return rl;
        else
            return cdr().reverseRec(rl.cons(car()));
    }

    /**
     * Visualizza la lista di Stringhe
     *
     * @return the StringSList in String format
     */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "(---)";

        else if (restElements.isEmpty())
            return "(" + this.firstElement + ")";

        else {
            String elements = "(" + this.firstElement;
            StringSList restEl = this.restElements;

            while (!restEl.isEmpty()) {
                elements = elements + ", " + restEl.car();
                restEl = restEl.cdr();
            }

            return elements + ")";
        }
    }

    /**
     * Visualizza la lista di stringhe
     *
     * @param sList la lista di stringhe da visualizzare
     */
    public void display(StringSList sList) {
        String s = "(";
        String t = ")";

        System.out.print(s);

        for (String el : sList) {

            if (el != listRef(length() - 1))
                System.out.print(el + ", ");
            else
                System.out.print(el);
        }

        System.out.print(t);
    }

    /**
     * Crea una StringSList da un array di Stringhe
     *
     * @param l the array of strings
     * @return a StringSList with the element of the array
     */
    public static StringSList fromArray(String[] l) {
        StringSList list = new StringSList();

        for (String s : l) {
            list = list.cons(s);
        }

        return list.reverse();
    }

    /**
     * Iteratore: Permette di iterare sugli elementi della lista.
     *
     * @return the StringSList with the iterator() method
     */
    @Override
    public Iterator<String> iterator() {
        StringSList c = this;

        return new Iterator<>() {
            private StringSList current = c;

            @Override
            public boolean hasNext() {
                return current != null && !current.isEmpty();
            }

            @Override
            public String next() {
                String i = current.firstElement;
                current = current.restElements;
                return i;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
} // class StringSList
