package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        System.out.println("Testing add(2, 3): Expected = 5, Actual = " + result);
        assertEquals(5, result);
        System.out.println("Test Passed: add(2, 3) == 5");
    }
}
