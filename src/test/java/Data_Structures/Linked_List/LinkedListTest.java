package Data_Structures.Linked_List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> list;

    @Test
    @DisplayName("Linked List")
    void newLinkedList() {
        new LinkedList<Integer>();
    }

    @Nested
    @DisplayName("Class afterNewLinkedList")
    class afterNewLinkedList {

        // Executed before each @Test
        @BeforeEach
        void newList() {
            list = new LinkedList<>();
        }

        @Test
        @DisplayName("size")
        void getSize() {
            assertEquals(0, list.getSize());
        }

        @Test
        @DisplayName("isEmpty")
        void isEmpty() {
            assertTrue(list.isEmpty(), () -> "Empty");
        }

        @Nested
        @DisplayName("Class afterAddElements")
        class afterAddElements {

            Integer firstElement = 5;
            Integer lastElement = 8;

            // Executed before each @Test
            @BeforeEach
            @DisplayName("addElements")
            void addElements() {
                list.addFirst(firstElement);
                list.addLast(lastElement);
            }

            @Test
            @DisplayName("size")
            void getSize() {
                assertEquals(2, list.getSize());
            }

            @Test
            @DisplayName("isEmpty")
            void isEmpty() {
                assertFalse(list.isEmpty(), () -> "Not Empty");
            }

            @Test
            @DisplayName("first element")
            void first() {
                assertAll("properties", () -> {
                    assertFalse(list.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("first element", () -> assertEquals(firstElement, list.first()));
                });
            }

            @Test
            @DisplayName("last element")
            void last() {
                assertAll("properties", () -> {
                    assertFalse(list.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("last element", () -> assertEquals(lastElement, list.last()));
                });
            }

            @Test
            @DisplayName("indexOf")
            void indexOf() {
                assertEquals(0, list.indexOf(firstElement));
                assertEquals(1, list.indexOf(lastElement));
            }

            @Test
            @DisplayName("belong")
            void belong() {
                assertFalse(list.isEmpty(), () -> "Not Empty");
                assertTrue(list.belong(lastElement), () -> "OK");
            }

            @Test
            @DisplayName("changeFirst")
            void changeFirst() {
                assertAll("properties", () -> {
                    assertFalse(list.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("new first element", () -> list.changeFirst(9));
                    assertEquals(9, list.first());
                });
            }

            @Test
            @DisplayName("removeFirst")
            void removeFirst() {
                assertAll("properties", () -> {
                    assertFalse(list.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("Remove first element", () -> assertEquals(firstElement, list.removeFirst()));
                });
            }

            @Test
            @DisplayName("changeLast")
            void changeLast() {
                assertAll("properties", () -> {
                    assertFalse(list.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("new last element", () -> list.changeLast(10));
                    assertEquals(10, list.last());
                });
            }

            @Test
            @DisplayName("ToString")
            void testToString() {
                String message = list.toString();
                assertEquals(list.toString(), message);
            }
        }
    }
}