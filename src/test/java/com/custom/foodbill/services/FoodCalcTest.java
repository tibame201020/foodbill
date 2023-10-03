package com.custom.foodbill.services;

import com.custom.foodbill.models.food.FoodRecommendInTake;
import com.custom.foodbill.services.impl.FoodCalcImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@SpringBootTest(classes = FoodCalcImpl.class)
class FoodCalcTest {
    private final FoodCalc foodCalc;

    @Autowired
    public FoodCalcTest(FoodCalc foodCalc) {
        this.foodCalc = foodCalc;
    }

    @Test
    void getFoodRecommendInTake() {
        BigDecimal calories = BigDecimal.valueOf(1350);
        FoodRecommendInTake expect1 = FoodCalc.getFoodRecommendInTake(1200);
        FoodRecommendInTake expect2 = FoodCalc.getFoodRecommendInTake(1500);

        Flux<FoodRecommendInTake> result = foodCalc.getFoodRecommendInTake(calories).log();

        StepVerifier.create(result)
                .expectNext(expect1)
                .expectNext(expect2)
                .verifyComplete();
    }
}