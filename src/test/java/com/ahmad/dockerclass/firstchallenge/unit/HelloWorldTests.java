package com.ahmad.dockerclass.firstchallenge.unit;

import com.ahmad.dockerclass.firstchallenge.model.HelloWorld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HelloWorldTests {

    @ParameterizedTest
    @MethodSource("createHelloWorldInputTestData")
    public void GetCorrectHelloWorldMessage(String inputName, String ExpectedValue) {
        HelloWorld sut = new HelloWorld(inputName);

        Assertions.assertEquals(ExpectedValue, sut.getMessage());
    }

    public static Stream<Arguments> createHelloWorldInputTestData() {
        String greetingsWord = "Hello";
        String greetingsMessagePattern = greetingsWord + " %s";
        String noNamePerson = "Stranger";

        return Stream.of(
                Arguments.of("ABC", String.format(greetingsMessagePattern, "ABC")),
                Arguments.of("aBC", String.format(greetingsMessagePattern, "a BC")),
                Arguments.of("Ahmad", String.format(greetingsMessagePattern, "Ahmad")),
                Arguments.of("ahmad", String.format(greetingsMessagePattern, "ahmad")),
                Arguments.of("ahmadFarzaneh", String.format(greetingsMessagePattern, "ahmad Farzaneh")),
                Arguments.of("ahmadFarzanehLateran", String.format(greetingsMessagePattern, "ahmad Farzaneh Lateran")),
                Arguments.of("AhmadFarzaneh", String.format(greetingsMessagePattern, "Ahmad Farzaneh")),
                Arguments.of("AhmadFarzanehLateran", String.format(greetingsMessagePattern, "Ahmad Farzaneh Lateran")),
                Arguments.of(null, String.format(greetingsMessagePattern, noNamePerson)),
                Arguments.of("", String.format(greetingsMessagePattern, noNamePerson)),
                Arguments.of(" ", String.format(greetingsMessagePattern, noNamePerson)),
                Arguments.of("   ", String.format(greetingsMessagePattern, noNamePerson))
        );
    }
}
