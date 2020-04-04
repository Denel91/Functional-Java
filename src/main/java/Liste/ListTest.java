package Liste;

/**
 * Classe di test per gli oggetti di tipo IntSList
 *
 * test() : int
 * range(int m, int n) : IntSList
 * iterativeRange(int m, int n) : IntSList
 * between(int i, int minValueInclusive, int maxValueInclusive) : boolean
 * test2(int m, int n) : void
 *
 * @version 26/03/2020
 */
public class ListTest {

    /**
     * Metodo di test
     */
    public static void test() {
        IntSList il = new IntSList();
        il = new IntSList(5, il);
        il = il.cons(4);

        System.out.println(il.isNull() ? "Empty" : "Not Empty");
        System.out.println(il.toString());
    }

    /**
     * Crea una lista di interi a partire da m fino ad n
     *
     * @param m the first element of the IntSList. REQUIRE m < n
     * @param n the last element of the IntSList. REQUIRE n > m
     * @return the IntSList from m to n
     */
    public static IntSList range(int m, int n) {
        if (m > n) {
            return IntSList.NULL_INTLIST;
        } else {
            return range(m + 1, n).cons(m);
        }
    }

    /**
     * Crea una lista di interi a partire da m fino ad n
     * (Iterative mode)
     *
     * @param m the first element of the IntSList. REQUIRE m < n
     * @param n the last element of the IntSList. REQUIRE n > m
     * @return the IntSList from m to n
     */
    public static IntSList iterativeRange(int m, int n) {
        IntSList list = new IntSList();

        for (int i = n; i >= m; i--) {

            list = list.cons(i);
        }

        return list;
    }

    /**
     * Verifica se un numero è presente in un intervallo tra minValueInclusive e maxValueInclusive
     *
     * @param i                 the number to verify
     * @param minValueInclusive the first number of the interval
     * @param maxValueInclusive the last number of the interval
     * @return true if i is between minValueInclusive and maxValueInclusive
     */
    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return i >= minValueInclusive && i <= maxValueInclusive;
    }

    /**
     * Metodo di test
     *
     * @param m the first element of the IntSList
     * @param n the last element of the IntSList
     */
    public static void test2(int m, int n) {
        IntSList sList = range(m, n);
        IntSList il = iterativeRange(m, n);
        IntSList al = il.reverse();

        System.out.println("sList -> " + sList.toString());
        System.out.println("il -> " + il.toString());
        System.out.println("al -> " + al.toString());

        // Test dei metodi
        //System.out.println(il.append(al));
        // System.out.println(il.equals(al));
        // System.out.println(il.reverse());
        // System.out.println(il.listRef(3));
        // System.out.println(il.length());
    }

    /**
     * Metodo di test
     *
     * @param m the first element of il
     * @param n the last element of il
     * @param k the first element of al
     * @param y the last element of al
     */
    public static void test3(int m, int n, int k, int y) {
        IntSList il = iterativeRange(m, n);
        IntSList al = iterativeRange(k, y);

        System.out.println("il -> " + il.toString());
        System.out.println("al -> " + al.toString());

        // Test dei metodi
        System.out.println(il.append(al));
    }

    public static void main(String[] args) {

        IntSList intSList = new IntSList();
        intSList = new IntSList(4, intSList);
        intSList = intSList.cons(7);
        intSList = intSList.cons(8);
        intSList = intSList.cons(3);

        //intSList.display(intSList);

        //System.out.println(intSList.listRef(3));

        //System.out.println("List -> " + intSList.toString());

        //System.out.println("Legth -> " + intSList.length());

        //test();

        //test2(1, 4);

        test3(1, 4, 5, 8);

        //System.out.println("\n" + between(4, 2, 8));
    }
}
