package com.doz;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NewtonRaphsonSquareRoot {

    private static final BigDecimal TWO = new BigDecimal(2);

    private final BigDecimal toRoot;
    private final BigDecimal startValue;
    private final int lastIteration;
    private final int precision;

    public NewtonRaphsonSquareRoot(int lastIteration, int precision, BigDecimal toRoot, BigDecimal startValue) {
        this.lastIteration = lastIteration;
        this.toRoot = toRoot;
        this.startValue = startValue;
        this.precision = precision;
    }

    public BigDecimal calc() {
        return this.calc(this.startValue, 0);
    }

    private BigDecimal calc(BigDecimal startApproximation, int iteration) {
        BigDecimal nextApproximation = startApproximation
                .add(toRoot.divide(startApproximation, this.precision , RoundingMode.HALF_UP))
                .divide(TWO, this.precision, RoundingMode.HALF_UP);

        System.out.println(nextApproximation);

        if (iteration >= lastIteration) {
            return nextApproximation;
        } else {
            return this.calc(nextApproximation, ++iteration);
        }
    }
}
