package de.dikodam.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PolicyTest {

    @Test
    fun validate() {
        assertAll(
            { assertThat(Policy(1, 3, 'a').validate("abcde")).isTrue() },
            { assertThat(Policy(1, 3, 'b').validate("cdefg")).isFalse() },
            { assertThat(Policy(2, 9, 'c').validate("ccccccccc")).isTrue() }
        )
    }
}