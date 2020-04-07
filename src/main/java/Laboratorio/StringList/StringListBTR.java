package Laboratorio.StringList;

import Liste.StringSList;

import static Laboratorio.Codifica_in_Java.CodSchemeToJava.btrSucc;

/**
 * Definisci una procedura (metodo statico) che, data una stringa btr (oggetto di tipo String)
 * che rappresenta un intero non negativo nella notazione BTR (Balanced Ternary Representation)
 * e dato un intero non negativo n (valore di tipo int), restituisce la lista di n interi consecutivi
 * in notazione BTR, a partire da btr.
 * Per esempio, se btr = "+-" e n = 5, la lista risultante deve contenere le cinque stringhe ("+-", "+.", "++",
 * "+--", "+-.") nell’ordine.
 *
 * @version 07/04/2020
 */

public class StringListBTR {
    public static void main(String[] args) {

        StringSList btrList = test("+-", 5);
        System.out.println("btrList -> " + btrList.toString());
    }

    /**
     * Costruisce una lista di stringhe in notazione BTR
     *
     * @param r stringa di -/./+
     * @param n la dimensione della lista StringSList
     * @return a new StringSList
     */
    public static StringSList test(String r, int n) {
        StringSList list = new StringSList();

        for (int i = n; i > 0; i--) {

            list = list.cons(r);
            r    = btrSucc(r);
        }

        return list.reverse();
    }
}
