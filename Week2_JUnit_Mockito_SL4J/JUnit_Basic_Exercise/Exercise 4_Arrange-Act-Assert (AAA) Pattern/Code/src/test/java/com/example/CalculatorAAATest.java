package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calc;

    @Before
    public void setUp() {
        System.out.println("\nSetting up Calculator instance...");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator instance...");
        calc = null;
    }

    @Test
    public void testAddition_AAA() {
        System.out.println("Test: Addition - 10 + 5");

        // Arrange
        int a = 10, b = 5;
        System.out.println("Arrange: a = " + a + ", b = " + b);

        // Act
        int result = calc.add(a, b);
        System.out.println("Act: calc.add(a, b) = " + result);

        // Assert
        assertEquals(15, result);
        System.out.println("Assert: Result is correct (15)");
    }

    @Test
    public void testMultiplication_AAA() {
        System.out.println("Test: Multiplication - 4 * 3");

        // Arrange
        int a = 4, b = 3;
        System.out.println("Arrange: a = " + a + ", b = " + b);

        // Act
        int result = calc.multiply(a, b);
        System.out.println("Act: calc.multiply(a, b) = " + result);

        // Assert
        assertEquals(12, result);
        System.out.println("Assert: Result is correct (12)");
    }
}
