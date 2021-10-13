package com.epam.brest.calc;

import java.math.BigDecimal;

public class CalcImpl implements Calc {
    BigDecimal weight;
    BigDecimal distance;
    BigDecimal priceKm;
    BigDecimal priceKg;

    public CalcImpl(BigDecimal weight, BigDecimal distance,  BigDecimal priceKm, BigDecimal priceKg) {
        this.weight = weight;
        this.distance = distance;
        this.priceKm = priceKm;
        this.priceKg = priceKg;
    }


    @Override
    public BigDecimal calculator(BigDecimal weight, BigDecimal priceKg, BigDecimal length, BigDecimal priceKm) {
         return weight.multiply(priceKg).add(distance.multiply(priceKm));
    }
}