package de.dikodam.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AoCUtilsKtTest {

    @Test
    fun firstHalf() {
        val firstHalf = (4..7).firstHalf()
        assertAll(
            { assertThat(firstHalf.first).isEqualTo(4) },
            { assertThat(firstHalf.last).isEqualTo(5) }
        )
    }

    @Test
    fun secondHalf() {
        val firstHalf = (4..7).secondHalf()
        assertAll(
            { assertThat(firstHalf.first).isEqualTo(6) },
            { assertThat(firstHalf.last).isEqualTo(7) }
        )
    }
}