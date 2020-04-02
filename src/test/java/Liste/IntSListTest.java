package Liste;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for IntSList
 */
class IntSListTest {

    private IntSList sList = new IntSList();
    private IntSList list = new IntSList();

    @Test
    void isNull() {
        sList = new IntSList(5, sList);
        list = new IntSList();
        assertFalse(sList.isNull(), "Not Empty");
        assertTrue(list.isNull(), "Empty");
    }

    @Test
    void car() {
        sList = new IntSList(5, sList);
        sList = sList.cons(3);
        assertEquals(3, sList.car());
    }

    @Test
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
    void cons() {
        list = new IntSList(cInput, list);
        assertEquals(cExpected, list.car());
    }

    @Test
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
    void testEquals() {
    }

    @Test
    void append() {
    }

    @Test
    void reverse() {
    }

    @Test
    void testToString() {
    }
}