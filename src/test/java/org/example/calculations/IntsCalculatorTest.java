package org.example.calculations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Тест класса IntsCalculator.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IntsCalculatorTest {

    private static IntsCalculator intsCalculator;

    @BeforeAll
    static void setUp() {
        intsCalculator = new IntsCalculator();
    }

    @AfterAll
    static void tearDown() {
        intsCalculator = null;
    }

    @Order(1)
    @DisplayName("Тест: sum(a, b) => ")
    @MethodSource("getArgumentsSum")
    @ParameterizedTest(name = "{0} + {1} = {2} ")
    void sum(int a, int b, int expected) {
        Assertions.assertEquals(expected, intsCalculator.sum(a, b));
    }

    private static Stream<Arguments> getArgumentsSum() {
        return Stream.of(
                Arguments.of(10, 10, 20),
                Arguments.of(-10, 10, 0),
                Arguments.of(-10, -10, -20),
                Arguments.of(0, 10, 10),
                Arguments.of(0, 0, 0)
        );
    }

    @Order(2)
    @DisplayName("Тест: mult(a, b) => ")
    @MethodSource("getArgumentsMult")
    @ParameterizedTest(name = "{0} * {1} = {2} ")
    void mult(int a, int b, int expected) {
        Assertions.assertEquals(expected, intsCalculator.mult(a, b));
    }

    private static Stream<Arguments> getArgumentsMult() {
        return Stream.of(
                Arguments.of(10, 10, 100),
                Arguments.of(-10, 10, -100),
                Arguments.of(-10, -10, 100),
                Arguments.of(10, 0, 0),
                Arguments.of(0, 10, 0)
        );
    }

    @Order(3)
    @DisplayName("Тест: pow(a, b) => ")
    @MethodSource("getArgumentsPow")
    @ParameterizedTest(name = "{0} ^ {1} = {2} ")
    void pow(int a, int b, int expected) {
        Assertions.assertEquals(expected, intsCalculator.pow(a, b));
    }

    private static Stream<Arguments> getArgumentsPow() {
        return Stream.of(
                Arguments.of(10, 2, 100),
                Arguments.of(10, -2, 0),
                Arguments.of(10, 0, 1),
                Arguments.of(-10, 3, -1000),
                Arguments.of(-10, 1, -10)
        );
    }

    @Order(4)
    @DisplayName("Тест: div(a, b) => ")
    @MethodSource("getArgumentsDiv")
    @ParameterizedTest(name = "{0} / {1} = {2} ")
    void div(int a, int b, int expected) {
        Assertions.assertEquals(expected, intsCalculator.div(a, b));
    }

    private static Stream<Arguments> getArgumentsDiv() {
        return Stream.of(
                Arguments.of(10, 1, 10),
                Arguments.of(10, 2, 5),
                Arguments.of(10, -2, -5),
                Arguments.of(-10, 1, -10),
                Arguments.of(-10, 3, -3),
                Arguments.of(2, 10, 0),
                Arguments.of(0, 10, 0)
        );
    }

    @Test
    @Order(5)
    void divByZeroThrowsArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> intsCalculator.div(10, 0));
    }
}