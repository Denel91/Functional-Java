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

        intSList.display(intSList);

        //System.out.println("List -> " + intSList.toString());

        //System.out.println("Legth -> " + intSList.length());

        //System.out.println(ListTest.test());
    }
}
