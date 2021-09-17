package com.doz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class NewtonRaphsonSquareRootTest {

    @Test
    public void testSquareRootTwoPrecisionEleven() {
        // GIVEN
        BigDecimal two = BigDecimal.valueOf(2);

        // WHEN
        BigDecimal result = new NewtonRaphsonSquareRoot(10, 11, two, two).calc();

        // THEN
        BigDecimal expected = BigDecimal.valueOf(1.41421356237);
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    public void testSquareRootTwoPrecisionTwelve() {
        // GIVEN
        BigDecimal two = BigDecimal.valueOf(2);

        // WHEN
        BigDecimal result = new NewtonRaphsonSquareRoot(10, 12, two, two).calc();

        // THEN
        BigDecimal expected = BigDecimal.valueOf(1.414213562373);
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    public void testSquareRootFour() {
        // GIVEN
        BigDecimal four = BigDecimal.valueOf(4);

        // WHEN
        BigDecimal result = new NewtonRaphsonSquareRoot(2, 0, four, four).calc();

        // THEN
        BigDecimal expected = BigDecimal.valueOf(2);
        assertThat(result).isEqualByComparingTo(expected);
    }
}