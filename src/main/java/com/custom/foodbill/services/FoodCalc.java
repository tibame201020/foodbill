package com.custom.foodbill.services;

import com.custom.foodbill.models.food.FoodRecommendInTake;

import java.math.BigDecimal;

public interface FoodCalc {
    /**
     * 根據卡路里回傳六大類建議攝取量
     * 來源為 衛生福利部 每日飲食指南手冊
     * www.hpa.gov.tw/File/Attach/6712/File_6253.pdf
     */
    FoodRecommendInTake getFoodRecommendInTake(BigDecimal calories);
}
