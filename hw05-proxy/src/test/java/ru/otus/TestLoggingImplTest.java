package ru.otus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestLoggingImplTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testCalculationOutputWithOneParameter() {
        TestLogging testLogging = ProxyBuilder.createMyClass();
        testLogging.calculation(6);
        assertEquals("executed method: calculation, params: [6]\r\nexecuted original method: calculation(6)\r\n",
                outContent.toString());
    }

    @Test
    void testCalculationOutputWithTwoParameters() {
        TestLogging testLogging = ProxyBuilder.createMyClass();
        testLogging.calculation(1, 3);
        assertEquals("executed method: calculation, params: [1, 3]\r\nexecuted original method: calculation(1, 3)\r\n",
                outContent.toString());
    }

    @Test
    void testCalculationOutputWithThreeParameters() {
        TestLogging testLogging = ProxyBuilder.createMyClass();
        testLogging.calculation(7,9,"One");
        assertEquals("executed method: calculation, params: [7, 9, One]\r\nexecuted original method: calculation(7, 9, One)\r\n",
                outContent.toString());
    }
}