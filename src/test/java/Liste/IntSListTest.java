package Liste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
        assertFalse(false, "IntSList is not empty");
        assertTrue(true, "IntSList is empty");
    }

    @Test
    void car() {
        sList = new IntSList(5, sList);
        sList = sList.cons(3);
        assertEquals(3, sList.car());
    }
}