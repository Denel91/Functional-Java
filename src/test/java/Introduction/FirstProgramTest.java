package Introduction;

import org.junit.jupiter.api.Assertions;

class FirstProgramTest {

    @org.junit.jupiter.api.Test
    public void multiplyByTwo() {
        FirstProgram program = new FirstProgram();
        int result = program.multiplyByTwo(2);
        Assertions.assertEquals(4, result, "OK");
    }
}