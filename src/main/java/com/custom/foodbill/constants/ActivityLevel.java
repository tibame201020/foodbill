package com.custom.foodbill.constants;

import java.math.BigDecimal;

/**
 * 計算TDEE加成
 * Total Daily Energy Expenditure calculator
 */
public enum ActivityLevel {
    LOW("每周運動頻率: 近乎沒有運動", BigDecimal.valueOf(1.2)),
    LIGHT("每周運動頻率: 1-3天", BigDecimal.valueOf(1.375)),
    MIDDLE("每周運動頻率: 3-5天", BigDecimal.valueOf(1.55)),
    HIGH("每周運動頻率: 每天", BigDecimal.valueOf(1.725)),
    HARD("每周運動頻率: 每天且長時間或劇烈運動", BigDecimal.valueOf(1.9));

    private final String description;
    private final BigDecimal bonus;

    ActivityLevel(String description, BigDecimal bonus) {
        this.description = description;
        this.bonus = bonus;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getBonus() {
        return bonus;
    }
}
