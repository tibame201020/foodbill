package com.custom.foodbill.constants;

public enum UserCustomCategory {
    /**
     * record時段
     * 早中晚餐並非所有人都這樣吃(ex 消夜, 點心
     * 故交由使用者自行定義
     */
    MEAL_TIME,
    /**
     * 食物屬性 根據不同需求的人,關注的營養攝取可能不同(ex:熱量, 蛋白質, 維生素
     * 故交由使用者自行定義
     */
    FOOD_PROP
}
