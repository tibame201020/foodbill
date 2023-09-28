package com.custom.foodbill.models.food;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FoodRecommendInTake implements Serializable {
    /**
     * 全穀雜糧類(碗)
     */
    private BigDecimal grains;
    /**
     * 豆魚蛋肉類(份)
     */
    private BigDecimal meatBeans;
    /**
     * 乳品類(杯)
     */
    private BigDecimal dairy;
    /**
     * 蔬菜類(份)
     */
    private BigDecimal vegetables;
    /**
     * 水果類(份)
     */
    private BigDecimal fruits;
    /**
     * 油脂與堅果種子類(份)
     */
    private BigDecimal oilsNuts;
}
