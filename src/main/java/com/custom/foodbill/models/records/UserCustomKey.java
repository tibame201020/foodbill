package com.custom.foodbill.models.records;

import com.custom.foodbill.constants.UserCustomCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 使用者變數
 */
@Data
@AllArgsConstructor
@Document("user_custom_key")
public class UserCustomKey implements Serializable {
    /**
     * 名稱
     */
    private String name;
    private UserCustomCategory userCustomCategory;
}
