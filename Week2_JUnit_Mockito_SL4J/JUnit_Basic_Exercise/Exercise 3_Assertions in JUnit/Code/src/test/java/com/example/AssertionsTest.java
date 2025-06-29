package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        int sum = 2 + 3;
        System.out.println("Checking if 2 + 3 == 5");
        assertEquals(5, sum);

        // Assert true
        System.out.println("Checking if 5 > 3 is true");
        assertTrue(5 > 3);

        // Assert false
        System.out.println("Checking if 5 < 3 is false");
        assertFalse(5 < 3);

        // Assert null
        System.out.println("Checking if null is null");
        assertNull(null);

        // Assert not null
        System.out.println("Checking if new Object() is not null");
        assertNotNull(new Object());

        System.out.println("All assertions passed successfully.");
    }
}
