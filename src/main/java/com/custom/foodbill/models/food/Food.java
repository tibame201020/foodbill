package com.custom.foodbill.models.food;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * let user custom key in food for record
 */
@Data
@Document("food")
public class Food implements Serializable {
    /**
     * 食物名稱
     */
    @Id
    private String name;
    /**
     * 食物屬性
     * 根據UserCustomKey 且UserCustomCategory為FOOD_PROP產生
     */
    private Map<String, BigDecimal> foodProp;
    /**
     * 備註
     */
    private String ps;
}
