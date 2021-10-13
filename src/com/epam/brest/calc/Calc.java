package com.epam.brest.calc;

import java.math.BigDecimal;


@FunctionalInterface
public interface Calc {

    BigDecimal calculator(BigDecimal weight, BigDecimal pricePerKg, BigDecimal length, BigDecimal pricePerKm);


}