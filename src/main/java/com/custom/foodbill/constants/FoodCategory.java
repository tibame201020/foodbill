package com.custom.foodbill.constants;

public enum FoodCategory {
    GRAINS("全穀雜糧類(碗)"),
    MEAT_BEANS("豆魚蛋肉類(份)"),
    DAIRY("乳品類(杯)"),
    VEGETABLES("蔬菜類(份)"),
    FRUITS("水果類(份)"),
    OILS_NUTS("油脂與堅果種子類(份)");

    /**
     * 中文描述
     */
    private final String description;

    FoodCategory(String description) {
        this.description = description;
    }
}
