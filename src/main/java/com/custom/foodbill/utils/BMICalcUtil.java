package com.custom.foodbill.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Body Mass Index Calc
 * BMI 身體質量指數計算
 */
public class BMICalcUtil {

    /**
     * BMI calculator
     * 體重 / (身高 * 身高)
     */
    public static BigDecimal calcBMI(BigDecimal height, BigDecimal weight) {
        height = transHeight(height);
        return weight.divide(height.multiply(height), 1, RoundingMode.HALF_UP);
    }

    /**
     * find target weight
     * 根據bmi與身高 反推應該達到的體重
     */
    public static BigDecimal accordingTargetBMIFindWeight(BigDecimal bmi, BigDecimal height) {
        height = transHeight(height);
        return bmi.multiply(height.multiply(height))
                .setScale(1, RoundingMode.HALF_UP);
    }

    /**
     * ideal weight calculator
     * 理想體重計算
     */
    public static BigDecimal calcIdealWeight(BigDecimal height, boolean isMale) {
        if (isMale) {
            return calcMaleIdealWeight(height);
        } else {
            return calcFemaleIdealWeight(height);
        }
    }

    /**
     * male ideal weight
     * 男性理想體重計算
     * (身高 - 80) * 0.7
     */
    private static BigDecimal calcMaleIdealWeight(BigDecimal height) {
        return height.subtract(BigDecimal.valueOf(80))
                .multiply(BigDecimal.valueOf(0.7));
    }

    /**
     * female ideal weight
     * 女性理想體重計算
     * (身高 - 70) * 0.6
     */
    private static BigDecimal calcFemaleIdealWeight(BigDecimal height) {
        return height.subtract(BigDecimal.valueOf(70))
                .multiply(BigDecimal.valueOf(0.6));
    }

    /**
     * calc percent to ideal weight
     * 計算目前體重與理想體重差距百分比
     * (目前體重 - 理想體重) / 目前體重 * 100
     */
    public static BigDecimal calcPercentToIdealWeight(BigDecimal height, BigDecimal weight, boolean isMale) {
        BigDecimal idealWeight = calcIdealWeight(height, isMale);
        return weight.subtract(idealWeight)
                .divide(idealWeight, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(0, RoundingMode.CEILING);
    }

    /**
     * height cm to m
     * 轉換公分到公尺
     */
    private static BigDecimal transHeight(BigDecimal height) {
        return height.divide(BigDecimal.valueOf(100.0), 2, RoundingMode.HALF_UP);
    }


}
