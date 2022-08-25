package Practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void findGCD() {
        Utils utils = new Utils();
        assertEquals(8,utils.findGCD(0,8));
        assertEquals(8,utils.findGCD(8,0));
        assertEquals(2,utils.findGCD(4,10));
        assertEquals(4,utils.findGCD(8,28));
        assertEquals(6,utils.findGCD(12,30));
    }
}