package com.custom.foodbill.utils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BMICalcUtilTest {

    @Test
    void BMICalc() {
        BigDecimal height = BigDecimal.valueOf(170);
        BigDecimal weight = BigDecimal.valueOf(63.0);
        BigDecimal expect = BigDecimal.valueOf(21.8);

        BigDecimal result = BMICalcUtil.calcBMI(height, weight);
        assertEquals(expect, result);
    }

    @Test
    void accordingTargetBMIFindWeight() {
        BigDecimal bmi = BigDecimal.valueOf(21.8);
        BigDecimal height = BigDecimal.valueOf(170);
        BigDecimal expect = BigDecimal.valueOf(63.0);

        BigDecimal result = BMICalcUtil.accordingTargetBMIFindWeight(bmi, height);
        assertEquals(expect, result);
    }

    @Test
    void calcIdealWeight() {
        BigDecimal height = BigDecimal.valueOf(170);
        boolean isMale = true;
        BigDecimal expect = BigDecimal.valueOf(63.0);

        BigDecimal result = BMICalcUtil.calcIdealWeight(height, isMale);
        assertEquals(expect, result);
    }

    @Test
    void calcPercentToIdealWeight() {
        BigDecimal height = BigDecimal.valueOf(170);
        BigDecimal weight = BigDecimal.valueOf(63.0);
        boolean isMale = true;
        BigDecimal expect = BigDecimal.ZERO;

        BigDecimal result = BMICalcUtil.calcPercentToIdealWeight(height, weight, isMale);
        assertEquals(expect, result);

    }
}