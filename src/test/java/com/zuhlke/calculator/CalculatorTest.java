package com.zuhlke.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    @Test
    void testEmptyStringShouldReturnZero() {
        Calculator calculator = new Calculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void testAddOneNumberShouldReturnNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.add("5");
        assertEquals(5, result);
    }

    @Test
    void testAddTwoNumbersShouldReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("5,5");
        assertEquals(10, result);
    }

    @Test
    void testAddFourNumbersShouldReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("5,5,6,2");
        assertEquals(18, result);
    }

    @Test
    void testAddThreeNumbersWithNewLineDelimiterShouldReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void testAddThreeNumbersWithDifferentDelimiterShouldReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("//;\n1;2;3");
        assertEquals(6, result);
    }

    @Test
    void testAddOneNegativeNumberShouldReturnIllegalArgumentExceptionWithNegativesNotAllowed() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.add("-2"), "negatives not allowed - -2");
    }

    @Test
    void testAddTwoNegativeNumberShouldReturnIllegalArgumentExceptionWithNegativesNotAllowed() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.add("-2,-3"), "negatives not allowed - -2 -3");
    }

    @Test
    void testAddThreeNegativeNumberShouldReturnIllegalArgumentExceptionWithNegativesNotAllowed() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.add("-2,-3,-5"), "negatives not allowed - -2 -3 -5");
    }

    @Test
    void testAddNumberButIgnoreNumbersEqualsTo1000ShouldStillReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("5,1000");
        assertEquals(5, result);
    }

    @Test
    void testAdd4NumbersButIgnoreNumbersEqualsTo1000ShouldStillReturnSum() {
        Calculator calculator = new Calculator();
        int result = calculator.add("5,1001,6,1000");
        assertEquals(11, result);
    }


}
