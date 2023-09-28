package com.custom.foodbill.models.records;

import com.custom.foodbill.models.food.Food;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 每日飲食紀錄
 */
@Data
@Document("food_intake_record")
public class FoodInTakeRecord implements Serializable {
    @Id
    private FoodInTakeRecordPk foodInTakeRecordPk;
    private Food food;
}
