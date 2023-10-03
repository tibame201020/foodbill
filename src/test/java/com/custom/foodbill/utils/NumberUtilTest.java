package com.custom.foodbill.utils;

import com.custom.foodbill.constants.Constants;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

class NumberUtilTest {

    @Test
    void findCloset() {
        BigDecimal target = BigDecimal.valueOf(1650);
        BigDecimal[] array = Constants.CALORIES_RANGE_ARRAY;
        BigDecimal expect1 = BigDecimal.valueOf(1500);
        BigDecimal expect2 = BigDecimal.valueOf(1800);

        Flux<BigDecimal> result = NumberUtil.findCloset(target, array).log();

        StepVerifier.create(result)
                .expectNext(expect1)
                .expectNext(expect2)
                .verifyComplete();
    }

    @Test
    void findClosetMax() {
        BigDecimal target = BigDecimal.valueOf(1350);
        BigDecimal[] array = Constants.CALORIES_RANGE_ARRAY;
        BigDecimal expect = BigDecimal.valueOf(1500);

        Mono<BigDecimal> result = NumberUtil.findClosetMax(target, array).log();

        StepVerifier.create(result)
                .expectNext(expect)
                .verifyComplete();
    }

    @Test
    void findClosetMin() {
        BigDecimal target = BigDecimal.valueOf(1350);
        BigDecimal[] array = Constants.CALORIES_RANGE_ARRAY;
        BigDecimal expect = BigDecimal.valueOf(1200);

        Mono<BigDecimal> result = NumberUtil.findClosetMin(target, array).log();

        StepVerifier.create(result)
                .expectNext(expect)
                .verifyComplete();
    }
}