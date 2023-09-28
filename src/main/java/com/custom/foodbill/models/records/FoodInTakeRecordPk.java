package com.custom.foodbill.models.records;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class FoodInTakeRecordPk implements Serializable {
    private LocalDate localDate;
    /**
     * 用餐時段
     * 根據UserCustomKey 且UserCustomCategory為FOOD_PROP產生
     */
    private String mealTime;
}
