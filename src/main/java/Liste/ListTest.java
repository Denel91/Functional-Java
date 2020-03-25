package Liste;

/**
 * Classe di test per gli oggetti di tipo IntSList
 *
 * test() : int
 *
 * @version 24/03/2020
 */
public class ListTest {

    /**
     * @return an Integer value; the first element of IntSList
     */
    public static int test() {
        IntSList il = new IntSList();
        il = new IntSList(5, il);
        il = il.cons(4);

        System.out.println("Stato corrente della lista: " + il.isNull());
        return il.cdr().car();
    }

    public static void main(String[] args) {

        IntSList intSList = new IntSList();
        intSList = new IntSList(4, intSList);
        intSList = intSList.cons(7);
        intSList = intSList.cons(8);
        intSList = intSList.cons(3);

        System.out.println("List -> " + intSList.toString());

        System.out.println("Legth -> " + intSList.length());

        System.out.println(ListTest.test());
    }
}

/**
 *
 * Prova di esecuzione del metodo toString():
 *
 * intSList = {IntSList@791} "(3, 8, 7, 4)"
 *      empty = false
 *      first = 3
 *      rest = {IntSList@834} "(8, 7, 4)"
 *          empty = false
 *          first = 8
 *          rest = {IntSList@836} "(7, 4)"
 *              empty = false
 *              first = 7
 *              rest = {IntSList@838} "(4)"
 *                  empty = false
 *                  first = 4
 *                  rest = {IntSList@840} "(---)"
 *                      empty = true
 *                      first = 0
 *                      rest = null
 */

