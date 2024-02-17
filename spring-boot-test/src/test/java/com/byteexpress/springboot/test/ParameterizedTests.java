package com.byteexpress.springboot.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 参数化测试，允许你在测试方法中使用不同的参数多次运行相同的测试代码
 *
 * @Author: ByteExpress
 * @Date: 2024/2/17 13:11
 * @Version V1.0
 */
public class ParameterizedTests {
    /**
     * 根据@CsvSource数据源进行测试
     */
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void testByCsvSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult, new Calculator().add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    /**
     * 根据@MethodSource数据源进行测试
     */
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(10, -5, 5)
        );
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("parameters")
    public void testByMethodSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult, new Calculator().add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    /**
     * 根据@EnumSource数据源进行测试
     */
    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    @ParameterizedTest
    @EnumSource(Operator.class)
    void testAdd(Operator operator) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;
        int result;

        switch (operator) {
            case ADD:
                result = calculator.add(a, b);
                assertEquals(15, result, "Addition result is not as expected");
                break;
            case SUBTRACT:
                result = calculator.subtract(a, b);
                assertEquals(5, result, "Subtraction result is not as expected");
                break;
            case MULTIPLY:
                result = calculator.multiply(a, b);
                assertEquals(50, result, "Multiplication result is not as expected");
                break;
            case DIVIDE:
                result = calculator.divide(a, b);
                assertEquals(2, result, "Division result is not as expected");
                break;
        }
    }


    public class Calculator {

        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Divisor cannot be zero");
            }
            return a / b;
        }
    }

}