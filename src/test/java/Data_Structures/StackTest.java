package Data_Structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Test
 */
class StackTest {

    Stack<Integer> stack;
    Stack<Integer> myStack;

    @Test
    @DisplayName("newStackTest")
    void newStackTest() {
        new Stack<Integer>();
        new Stack<Integer>();
    }

    @Nested
    @DisplayName("Class afterNewStack")
    class afterNewStack {

        // Executed before each @Test
        @BeforeEach
        void newStack() {
            stack = new Stack<Integer>();
        }

        @Test
        @DisplayName("isEmpty")
        void isEmpty() {
            assertTrue(stack.isEmpty(), () -> "Empty");
        }

        @Test
        @DisplayName("DefaultSize")
        void getDefaultSize() {
            assertEquals(10, stack.getDefaultSize());
        }

        @Test
        @DisplayName("getCapacity")
        void getCapacity() {
            assertEquals(10, stack.getCapacity());
        }

        @ParameterizedTest(name = "For example, the value {0} is the new capacity of the stack.")
        @ValueSource(ints = {6, 8, 12, 15})
        @DisplayName("setCapacity")
        void setCapacity(int capacity) {
            myStack = new Stack<Integer>(capacity);
            assertEquals(capacity, myStack.getCapacity());
        }

        @Test
        @DisplayName("testEquals")
        void testEquals() {
            myStack = new Stack<Integer>();
            assertTrue(myStack.equals(stack), () -> "Equals");
        }

        @Nested
        @DisplayName("Class afterPushing")
        class afterPushing {

            Integer number = 8;

            // Executed before each @Test
            @BeforeEach
            @DisplayName("pushElementStack")
            void pushElement() {
                stack.push(number);
            }

            @Test
            @DisplayName("isNotEmpty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty(), () -> "Not Empty");
            }

            @Test
            @DisplayName("size")
            void size() {
                assertEquals(1, stack.size());
            }

            @Test
            @DisplayName("getElements")
            void getElements() {
                assertAll("properties", () -> {
                    assertFalse(stack.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("elements", () -> assertEquals(stack.getElements(), stack.getElements()));
                });
            }

            @Test
            @DisplayName("peek")
            void peek() {
                assertAll("properties", () -> {
                    assertFalse(stack.isEmpty(), () -> "Not Empty");

                    // Executed only if the previous assertion is valid.
                    assertAll("first element ", () -> assertEquals(8, stack.peek()));
                });
            }

            @Test
            @DisplayName("pop")
            void pop() {
                assertEquals(number, stack.pop());
                assertTrue(stack.isEmpty(), () -> "Popped");
            }

            @Test
            @DisplayName("contains")
            void contains() {
                assertFalse(stack.isEmpty(), () -> "Not Empty");
                assertTrue(stack.contains(number), () -> "OK");
            }

            @Test
            @DisplayName("search")
            void search() {
                assertFalse(stack.isEmpty(), () -> "Not Empty");
                assertEquals(0, stack.search(number));
            }

            @Test
            @DisplayName("clear")
            void clear() {
                stack.clear();
                assertEquals(0, stack.size());
                assertTrue(stack.isEmpty(), () -> "OK");
            }

            @Test
            @DisplayName("clone")
            void testClone() {
                myStack = (Stack<Integer>) stack.clone();
                assertTrue(myStack.contains(number), () -> "OK");
                assertEquals(1, myStack.size());
                assertFalse(myStack.isEmpty(), () -> "Not Empty");
            }

            @Test
            @DisplayName("equals")
            void testEqualsAfterPush() {
                myStack = new Stack<Integer>();
                myStack.push(number);
                assertTrue(stack.equals(myStack), () -> "Equals");
            }

            @Test
            @DisplayName("toString")
            void testToString() {
                String message = stack.toString();
                assertEquals(stack.toString(), message);
            }
        }
    }
}