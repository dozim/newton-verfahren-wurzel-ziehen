package com.doz;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        BigDecimal value = BigDecimal.valueOf(67);

        NewtonRaphsonSquareRoot newtonRaphsonSquareRoot = new NewtonRaphsonSquareRoot(10, 50, value, BigDecimal.valueOf(10));
        newtonRaphsonSquareRoot.calc();
    }
}
