import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static it.aesys.MethodToTest.reverseString;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MethodToTestTests {

    private String string = "hello";

    @Test
    void methodWorks() {
        assertEquals(string.length(), reverseString(string).length());
    }

    @Test
    void
}
