package com.custom.foodbill.utils;

import com.custom.foodbill.constants.ActivityLevel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CaloriesCalcUtilTest {

    @Test
    void calcBasicBMR() {
        BigDecimal height = BigDecimal.valueOf(170);
        BigDecimal weight = BigDecimal.valueOf(63.0);
        int age = 30;
        boolean isMale = true;
        BigDecimal expect = BigDecimal.valueOf(1548);

        BigDecimal result = CaloriesCalcUtil.calcBasicBMR(height, weight, age, isMale);
        assertEquals(expect, result);
    }

    @Test
    void calcTDEE() {
        BigDecimal height = BigDecimal.valueOf(170);
        BigDecimal weight = BigDecimal.valueOf(63.0);
        int age = 30;
        boolean isMale = true;
        ActivityLevel activityLevel = ActivityLevel.HIGH;
        BigDecimal expect = BigDecimal.valueOf(2670);

        BigDecimal result = CaloriesCalcUtil.calcTDEE(height, weight, age, isMale, activityLevel);
        assertEquals(expect, result);
    }
}