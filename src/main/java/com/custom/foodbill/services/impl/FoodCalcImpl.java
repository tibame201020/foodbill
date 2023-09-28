package com.custom.foodbill.services.impl;

import com.custom.foodbill.models.food.FoodRecommendInTake;
import com.custom.foodbill.services.FoodCalc;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FoodCalcImpl implements FoodCalc {

    @Override
    public FoodRecommendInTake getFoodRecommendInTake(BigDecimal calories) {
        return null;
    }
}
