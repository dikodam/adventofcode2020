package de.dikodam.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardingPassTest {


    @Test
    fun stringToBoardingPass() {
        val (rowResult, columnResult) = BoardingPass.fromString("FBFBBFFRLR")

        assertAll(
            { assertThat(rowResult).isEqualTo(44) },
            { assertThat(columnResult).isEqualTo(5) }
        )
    }

}