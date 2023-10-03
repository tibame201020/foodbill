package com.custom.foodbill.services;

import com.custom.foodbill.constants.UserCustomCategory;
import com.custom.foodbill.models.records.UserCustomKey;
import reactor.core.publisher.Flux;

public interface UserCustomKeyService {

    /**
     * 取得預設參數
     * get default props for init
     * @param userCustomCategory userCustomKey種類
     * @return Flux<UserCustomKey>
     */
    Flux<UserCustomKey> getDefaultProp(UserCustomCategory userCustomCategory);

    /**
     * 取得UserCustomKey參數
     * 若無 取default
     * @param userCustomCategory userCustomKey種類
     * @return Flux<UserCustomKey>
     */
    Flux<UserCustomKey> getUserCustomKeyByUserCustomCategory(UserCustomCategory userCustomCategory);
}
