package com.custom.foodbill.utils;

import com.custom.foodbill.constants.ActivityLevel;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calories Calc
 * 卡路里計算
 */
public class CaloriesCalcUtil {

    /**
     * Basic BMR calculator
     * 基礎代謝率
     */
    public static BigDecimal calcBasicBMR(BigDecimal height, BigDecimal weight, int age, boolean isMale) {
        if (isMale) {
            return calcMaleBMR(height,  weight, age);
        } else {
            return calcFemaleBMR(height,  weight, age);
        }
    }

    /**
     * Basic Male BMR calculator
     * 男性基礎代謝率
     * 身高 * 6.25 + 體重 * 10 + 年齡 * 5 + 5
     */
    private static BigDecimal calcMaleBMR(BigDecimal height, BigDecimal weight, int age) {
        return calcBMRWithoutChargeSex(height,  weight, age)
                .add(BigDecimal.valueOf(5))
                .setScale(0, RoundingMode.HALF_UP);
    }

    /**
     * Basic Female BMR calculator
     * 女性基礎代謝率
     * 身高 * 6.25 + 體重 * 10 + 年齡 * 5 - 161
     */
    private static BigDecimal calcFemaleBMR(BigDecimal height, BigDecimal weight, int age) {
        return calcBMRWithoutChargeSex(height,  weight, age)
                .subtract(BigDecimal.valueOf(161))
                .setScale(0, RoundingMode.HALF_UP);
    }

    /**
     * Basic BMR calculator without charge sex
     * 基礎代謝率共通公式
     * 身高 * 6.25 + 體重 * 10 + 年齡 * 5
     */
    private static BigDecimal calcBMRWithoutChargeSex(BigDecimal height, BigDecimal weight, int age) {
        BigDecimal heightBonus = height.multiply(BigDecimal.valueOf(6.25));
        BigDecimal weightBonus = weight.multiply(BigDecimal.TEN);
        BigDecimal ageBonus = BigDecimal.valueOf(age).multiply(BigDecimal.valueOf(5));

        return heightBonus.add(weightBonus).subtract(ageBonus);
    }

    /**
     * Total Daily Energy Expenditure calculator
     * 每日總熱量消耗
     * 基礎代謝率 * 活動程度加成
     */
    public static BigDecimal calcTDEE(BigDecimal height, BigDecimal weight, int age, boolean isMale, ActivityLevel activityLevel) {
        return calcBasicBMR(height,  weight, age, isMale)
                .multiply(activityLevel.getBonus())
                .setScale(0, RoundingMode.HALF_UP);
    }
}
