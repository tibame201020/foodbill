package com.custom.foodbill.constants;

import java.math.BigDecimal;

/**
 * 常數
 */
public class Constants {

    /**
     * 衛服部建議食物攝取量卡路里區間
     */
    public static final BigDecimal[] CALORIES_RANGE_ARRAY = new BigDecimal[]{
            BigDecimal.valueOf(1200),
            BigDecimal.valueOf(1500),
            BigDecimal.valueOf(1800),
            BigDecimal.valueOf(2000),
            BigDecimal.valueOf(2200),
            BigDecimal.valueOf(2500),
            BigDecimal.valueOf(2700)
    };
}
