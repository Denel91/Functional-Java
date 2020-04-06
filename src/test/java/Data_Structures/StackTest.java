package Data_Structures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

class StackTest {

    @Test
    @DisplayName("size")
    void size() {
    }

    @Test
    @DisplayName("DefaultSize")
    void getDefaultSize() {
    }

    @Test
    @DisplayName("getCapacity")
    void getCapacity() {
    }

    @DisplayName("setCapacity")
    @ParameterizedTest(name = "For example, the value {0} is the new capacity of the stack.")
    @ValueSource(ints = {5, 8, 12, 17})
    void setCapacity(int capacity) {
        Stack<Integer> stack = new Stack<Integer>(capacity);
        assertEquals(capacity, stack.getCapacity());
    }

    @Test
    @DisplayName("getElements")
    void getElements() {
    }

    @Test
    @DisplayName("isEmpty")
    void isEmpty() {
    }

    @Test
    @DisplayName("peek")
    void peek() {
    }

    @Test
    @DisplayName("pop")
    void pop() {
    }

    @Test
    @DisplayName("push")
    void push() {
    }

    @Test
    @DisplayName("contains")
    void contains() {
    }

    @Test
    @DisplayName("search")
    void search() {
    }

    @Test
    @DisplayName("clear")
    void clear() {
    }

    @Test
    @DisplayName("Clone")
    void testClone() {
    }

    @Test
    @DisplayName("Equals")
    void testEquals() {
    }

    @Test
    @DisplayName("ToString")
    void testToString() {
    }
}