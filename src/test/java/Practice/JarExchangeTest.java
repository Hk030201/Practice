package Practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JarExchangeTest {

    @Test
    void findMinimumNoOfSteps() {
        assertEquals(2,JarExchange.findMinimumNoOfSteps(5,2,3));
        assertEquals(6,JarExchange.findMinimumNoOfSteps(3,5,4));
        assertEquals(-1,JarExchange.findMinimumNoOfSteps(2,4,9));
    }
}