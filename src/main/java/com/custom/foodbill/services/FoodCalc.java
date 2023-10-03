package com.custom.foodbill.services;

import com.custom.foodbill.models.food.FoodRecommendInTake;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

public interface FoodCalc {
    /**
     * 根據卡路里回傳六大類食物建議攝取量
     * 來源為 衛生福利部 每日飲食指南手冊
     * www.hpa.gov.tw/File/Attach/6712/File_6253.pdf
     */
    static FoodRecommendInTake getFoodRecommendInTake(int calories) {
        FoodRecommendInTake foodRecommendInTake = new FoodRecommendInTake();
        foodRecommendInTake.setCalories(calories);
        switch (calories) {
            case 1200 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(3));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(3));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(2));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(4));
            }
            case 1500 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(2.5));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(4));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(3));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(2));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(4));
            }
            case 1800 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(3));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(5));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(3));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(2));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(5));
            }
            case 2000 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(3));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(6));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(4));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(3));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(6));
            }
            case 2200 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(3.5));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(6));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(4));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(3.5));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(6));
            }
            case 2500 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(4));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(7));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(1.5));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(5));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(4));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(7));
            }
            case 2700 -> {
                foodRecommendInTake.setGrains(BigDecimal.valueOf(4));
                foodRecommendInTake.setMeatBeans(BigDecimal.valueOf(8));
                foodRecommendInTake.setDairy(BigDecimal.valueOf(2));
                foodRecommendInTake.setVegetables(BigDecimal.valueOf(5));
                foodRecommendInTake.setFruits(BigDecimal.valueOf(4));
                foodRecommendInTake.setOilsNuts(BigDecimal.valueOf(8));
            }
        }

        return foodRecommendInTake;
    }

    /**
     * 取得六大類食物建議攝取量
     *
     * @param calories 卡路里
     * @return FoodRecommendInTake
     */
    Flux<FoodRecommendInTake> getFoodRecommendInTake(BigDecimal calories);
}
