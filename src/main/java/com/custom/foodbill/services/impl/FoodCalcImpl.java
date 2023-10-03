package com.custom.foodbill.services.impl;

import com.custom.foodbill.constants.Constants;
import com.custom.foodbill.models.food.FoodRecommendInTake;
import com.custom.foodbill.services.FoodCalc;
import com.custom.foodbill.utils.NumberUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Service
public class FoodCalcImpl implements FoodCalc {

    @Override
    public Flux<FoodRecommendInTake> getFoodRecommendInTake(BigDecimal calories) {
        return Flux
                .from(NumberUtil.findCloset(calories, Constants.CALORIES_RANGE_ARRAY))
                .map(bigDecimal -> FoodCalc.getFoodRecommendInTake(bigDecimal.intValue()));
    }
}
