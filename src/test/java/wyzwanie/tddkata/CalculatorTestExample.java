package wyzwanie.tddkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTestExample {

    @ParameterizedTest
    @MethodSource
    public void calculator_should_add_numbers(String input, Integer expectedResult) {
        //given
        Calculator calculatorUnderTest = new Calculator();

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(expectedResult));
    }

    private static Stream<Arguments> calculator_should_add_numbers() {
        return Stream.of(
            Arguments.of("", 0),
            Arguments.of(null, 0),
            Arguments.of("42", 42),
            Arguments.of("7,11", 18),
            Arguments.of("a,3", 3),
            Arguments.of("3,", 3),
            Arguments.of("2,3,4", 9),
            Arguments.of("//[;]\n1;2;3", 6),
            Arguments.of("//[,]\n1,2,3", 6)
        );
    }

    @Test
    public void should_return_error_when_no_comma_as_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1;3";

        //when
        Assertions.assertThrows(Exception.class, () -> calculatorUnderTest.add(input));
    }

}