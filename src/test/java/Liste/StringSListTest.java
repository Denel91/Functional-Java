package Liste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for StringSList
 *
 * @version 04/04/2020
 */
class StringSListTest {

    // Liste per i test
    private StringSList sList = new StringSList();
    private StringSList list = new StringSList();
    private StringSList listString = new StringSList();
    private StringSList singly = new StringSList();

    @Test
    @DisplayName("isEmpty")
    void isEmpty() {
        sList = new StringSList("Hello", sList);
        list = new StringSList();
        assertFalse(sList.isEmpty(), "Not Empty");
        assertTrue(list.isEmpty(), "Empty");
    }

    @Test
    @DisplayName("car")
    void car() {
        sList = new StringSList("Right", sList);
        sList = sList.cons("Are");
        sList = sList.cons("You");
        sList = sList.cons("Dan");
        sList = sList.cons("Yes");
        assertEquals("Yes", sList.car());
    }

    @Test
    @DisplayName("cdr")
    void cdr() {
        sList = new StringSList("Right", sList);
        sList = sList.cons("Are");
        sList = sList.cons("You");
        sList = sList.cons("Dan");
        sList = sList.cons("Yes");
        assertEquals(sList.cdr(), sList.cdr());
    }

    @Parameter
    public String input = "Jenkins";

    @Parameter
    public String expected = "Jenkins";

    @Test
    @DisplayName("cons")
    void cons() {
        list = new StringSList(input, list);
        assertEquals(expected, list.car());
    }

    @Test
    @DisplayName("length")
    void length() {
        singly = new StringSList();
        assertEquals(0, singly.length());

        singly = singly.cons("World");
        assertEquals(1, singly.length());

        list = new StringSList("Uno", list);
        list = list.cons("Due");
        list = list.cons("Tre");
        list = list.cons("Quattro");
        list = list.cons("Cinque");
        assertEquals(5, list.length());
    }

    @Parameter(2)
    public int index;

    @Test
    @DisplayName("listRef")
    void listRef() {
        singly = new StringSList("test", singly);
        singly = singly.cons("list");
        singly = singly.cons("ref");
        singly = singly.cons("for");
        singly = singly.cons("singly");

        assertFalse(singly.isEmpty(), "Not Empty");

        if (index == 0) {
            assertEquals("singly", singly.car());

        } else {
            assertEquals("ref", singly.cdr().listRef(index - 1));
        }
    }

    @Test
    @DisplayName("testEquals")
    void testEquals() {
        listString = new StringSList("Yes", listString);
        listString = listString.cons("We");
        listString = listString.cons("Are");
        listString = listString.cons("Equals");

        singly = new StringSList("Yes", singly);
        singly = singly.cons("We");
        singly = singly.cons("Are");
        singly = singly.cons("Equals");

        list = new StringSList("Uno", list);
        list = list.cons("Due");
        list = list.cons("Tre");
        list = list.cons("Quattro");

        assertTrue(listString.equals(singly), "Equals");

        assertFalse(singly.equals(list), "Not Equals");
    }

    @Test
    @DisplayName("append")
    void append() {
        singly = new StringSList("quattro", singly);
        singly = singly.cons("tre");
        singly = singly.cons("due");
        singly = singly.cons("uno");

        list = new StringSList("nove", list);
        list = list.cons("otto");
        list = list.cons("sette");
        list = list.cons("sei");
        list = list.cons("cinque");

        assertFalse(singly.isEmpty());
        assertFalse(list.isEmpty());

        assertEquals(4, singly.length());
        assertEquals(5, list.length());

        sList = singly.append(list);
        assertFalse(sList.isEmpty());
        assertEquals(9, sList.length());
    }

    @Test
    @DisplayName("reverse")
    void reverse() {
        singly = new StringSList("quattro", singly);
        singly = singly.cons("tre");
        singly = singly.cons("due");
        singly = singly.cons("uno");

        sList = singly.reverse();
        assertEquals("quattro", sList.car());
        assertEquals(sList.cdr(), sList.cdr());
    }

    /*
    @Test
    @DisplayName("ToString")
    void testToString() {
        sList = new StringSList();
        String message = sList.toString();
        assertEquals("(---)", message);

        list = new StringSList("dakota", list);
        String message_2 = list.toString();
        assertEquals("(dakota)", message_2);

        singly = new StringSList("quattro", singly);
        singly = singly.cons("tre");
        singly = singly.cons("due");
        singly = singly.cons("uno");
        String message_3 = singly.toString();
        assertEquals("(uno, due, tre, quattro)", message_3);
    }
    */

    @Parameter
    public String[] words = {"hello", "string", "junit5"};

    @Test
    @DisplayName("fromArray")
    void fromArray() {
        StringSList list = StringSList.fromArray(words);
        assertFalse(list.isEmpty());
        assertEquals(3, list.length());
        assertEquals("hello", list.car());
        assertEquals(list.cdr(), list.cdr());
    }
}