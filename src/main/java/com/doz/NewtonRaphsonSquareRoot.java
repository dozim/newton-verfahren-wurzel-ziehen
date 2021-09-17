package com.doz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.Nonnull;

public class NewtonRaphsonSquareRoot {

    private static final BigDecimal TWO = new BigDecimal(2);

    private final BigDecimal toSquareRoot;
    private final BigDecimal startValue;
    private final int lastIteration;
    private final int precision;

    public NewtonRaphsonSquareRoot(int lastIteration,
                                   int precision,
                                   @Nonnull BigDecimal toSquareRoot,
                                   @Nonnull BigDecimal startValue) {
        this.lastIteration = lastIteration;
        this.toSquareRoot = toSquareRoot;
        this.startValue = startValue;
        this.precision = precision + 1;
    }

    public BigDecimal calc() {
        return this.calc(this.startValue, 0).setScale(this.precision -1, RoundingMode.HALF_UP);
    }

    private BigDecimal calc(BigDecimal startApproximation, int iteration) {
        BigDecimal nextApproximation = startApproximation
                .add(toSquareRoot.divide(startApproximation, this.precision , RoundingMode.HALF_UP))
                .divide(TWO, this.precision, RoundingMode.HALF_UP);

        if (iteration >= lastIteration) {
            return nextApproximation;
        } else {
            return this.calc(nextApproximation, ++iteration);
        }
    }
}
