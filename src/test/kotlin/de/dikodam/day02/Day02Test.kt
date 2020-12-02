package de.dikodam.day02

import de.dikodam.KotlinParameterizedTest
import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@KotlinParameterizedTest
internal class Day02Test {

    private val testee = Day02()

    @ParameterizedTest
    @MethodSource("providePolicyAndPasswordArguments")
    fun parsePolicyAndPassword(
        commandString: String,
        expectedMin: Int,
        expectedMax: Int,
        expectedChar: Char,
        expectedPassword: String
    ) {

        val (policy, password) = testee.parsePolicyAndPassword(commandString)
        assertAll(
            { assertThat(policy.firstNumber).isEqualTo(expectedMin) },
            { assertThat(policy.secondNumber).isEqualTo(expectedMax) },
            { assertThat(policy.character).isEqualTo(expectedChar) },
            { assertThat(password).isEqualTo(expectedPassword) }
        )
    }

    fun providePolicyAndPasswordArguments() = Stream.of(
        Arguments.of("1-3 a: abcde", 1, 3, 'a', "abcde"),
        Arguments.of("1-3 b: cdefg", 1, 3, 'b', "cdefg"),
        Arguments.of("2-9 c: ccccccccc", 2, 9, 'c', "ccccccccc"),
    )

}