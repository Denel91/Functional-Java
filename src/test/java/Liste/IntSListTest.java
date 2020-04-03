package Liste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for IntSList
 */
class IntSListTest {

    private IntSList sList = new IntSList();
    private IntSList list = new IntSList();
    private IntSList intList = new IntSList();
    private IntSList isl = new IntSList();
    private IntSList singly = new IntSList();
    private IntSList il;
    private IntSList t;

    @Test
    @DisplayName("isNull")
    void isNull() {
        sList = new IntSList(5, sList);
        list = new IntSList();
        assertFalse(sList.isNull(), "Not Empty");
        assertTrue(list.isNull(), "Empty");
    }

    @Test
    @DisplayName("car")
    void car() {
        sList = new IntSList(5, sList);
        sList = sList.cons(3);
        assertEquals(3, sList.car());
    }

    @Test
    @DisplayName("cdr")
    void cdr() {
        list = new IntSList(7, list);
        list = list.cons(4);
        list = list.cons(6);
        list = list.cons(9);
        assertEquals(list.cdr(), list.cdr());
    }

    @Parameter(7)
    public int cInput;
    @Parameter(7)
    public int cExpected;

    @Test
    @DisplayName("cons")
    void cons() {
        list = new IntSList(cInput, list);
        assertEquals(cExpected, list.car());
    }

    @Test
    @DisplayName("length")
    void length() {
        list = new IntSList(7, list);
        list = list.cons(4);
        list = list.cons(6);
        list = list.cons(9);
        assertEquals(4, list.cdr().length() + 1);
    }

    @Parameter(2)
    public int index;

    @Test
    @DisplayName("listRef")
    void listRef() {
        list = new IntSList(7, list);
        list = list.cons(4);
        list = list.cons(6);
        list = list.cons(9);

        if (index == 0) {
            assertEquals(9, list.car());

        } else {
            assertEquals(6, list.cdr().listRef(index - 1));
        }
    }

    @Test
    @DisplayName("Equals")
    void testEquals() {
        list = new IntSList(7, list);
        list = list.cons(4);
        list = list.cons(6);
        list = list.cons(9);
        list = list.cons(5);

        sList = new IntSList(7, sList);
        sList = sList.cons(4);
        sList = sList.cons(6);
        sList = sList.cons(9);
        sList = sList.cons(5);

        intList = new IntSList(3, intList);
        intList = intList.cons(5);
        intList = intList.cons(2);
        intList = intList.cons(9);
        intList = intList.cons(6);

        assertTrue(list.equals(sList), "Equals");

        assertFalse(list.equals(intList), "Not Equals");
    }

    @Test
    @DisplayName("append")
    void append() {
        singly = new IntSList();
        assertTrue(singly.isNull());
        assertEquals(0, singly.length());

        list = new IntSList(7, list);
        list = list.cons(4);
        list = list.cons(6);
        list = list.cons(9);
        list = list.cons(5);

        singly = new IntSList(2, singly);
        singly = singly.cons(6);
        singly = singly.cons(7);
        assertFalse(singly.isNull());
        assertEquals(3, singly.length());

        t = singly.append(list);
        assertEquals(8, t.length());
    }

    @Test
    @DisplayName("reverse")
    void reverse() {
        list = new IntSList(5, list);
        list = list.cons(4);
        list = list.cons(3);
        list = list.cons(2);
        list = list.cons(1);

        il = list.reverse();
        assertEquals(5, il.car());
        assertEquals(list.cdr(), list.cdr());
    }

    @Test
    @DisplayName("ToString")
    void testToString() {
        isl = new IntSList();
        String message = isl.toString();
        assertEquals("(---)", message);

        sList = new IntSList(8, sList);
        String message_2 = sList.toString();
        assertEquals("(8)", message_2);

        list = new IntSList(5, list);
        list = list.cons(4);
        list = list.cons(3);
        list = list.cons(2);
        list = list.cons(1);

        String message_3 = list.toString();
        assertEquals("(1, 2, 3, 4, 5)", message_3);
    }
}