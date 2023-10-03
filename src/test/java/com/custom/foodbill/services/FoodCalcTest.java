package com.custom.foodbill.services;

import com.custom.foodbill.models.food.FoodRecommendInTake;
import com.custom.foodbill.services.impl.FoodCalcImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class FoodCalcTest {
    @InjectMocks
    private FoodCalcImpl foodCalc;

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