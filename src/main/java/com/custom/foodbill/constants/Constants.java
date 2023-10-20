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

    public static final String LOCAL_DEV = "http://localhost:5173/";
    /**
     * for 接受跨域請求使用
     */
    public static final String[] CORS_URLS = new String[]{LOCAL_DEV};

}
