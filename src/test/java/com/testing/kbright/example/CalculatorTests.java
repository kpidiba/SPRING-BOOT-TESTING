package com.testing.kbright.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.testing.kbright.models.Calculator;

/**
 * This class contains unit tests for the Calculator class.
 *
 * @author KbrightCoder
 */
public class CalculatorTests {

    /**
     * The calculator instance used for testing.
     */
    Calculator calculator;

    /**
     * Sets up the calculator instance before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * Tests the multiply method of the calculator.
     */
    @Test
    void testMultiply() {
        // Tests that the product of 4 and 5 is 20
        assertEquals(20, calculator.multiply(4, 5),
                "Multiplication failed.");
    }

    /**
     * Tests the divide method of the calculator.
     */
    @Test
    void testDivide() {
        // Tests that the division of 0 by 0 is 1
        assertEquals(1, calculator.divide(0, 0),
                "Division by zero failed.");
    }
}
