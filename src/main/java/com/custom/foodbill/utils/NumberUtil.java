package com.custom.foodbill.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class NumberUtil {

    /**
     * 找近似值
     * combine findClosetMax and findClosetMin then distinct
     * 若有兩者符合 則都回傳
     */
    public static Flux<BigDecimal> findCloset(BigDecimal target, BigDecimal[] array) {
        return findClosetMin(target, array)
                .concatWith(findClosetMax(target, array))
                .distinct();
    }


    /**
     * 找近似值
     * 若有兩者符合 取較大者
     */
    public static Mono<BigDecimal> findClosetMax(BigDecimal target, BigDecimal[] array) {
        return Flux.fromArray(array)
                .reduce((a, b) -> {
                            BigDecimal diffA = a.subtract(target).abs();
                            BigDecimal diffB = b.subtract(target).abs();
                            return diffA.compareTo(diffB) < 0 ? a : b;
                        }
                );
    }

    /**
     * 找近似值
     * 若有兩者符合 取較小者
     */
    public static Mono<BigDecimal> findClosetMin(BigDecimal target, BigDecimal[] array) {
        return Flux.fromArray(array)
                .reduce((a, b) -> {
                            BigDecimal diffA = a.subtract(target).abs();
                            BigDecimal diffB = b.subtract(target).abs();
                            return diffA.compareTo(diffB) <= 0 ? a : b;
                        }
                );
    }
}
