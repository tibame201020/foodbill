package com.custom.foodbill.controllers;

import com.custom.foodbill.constants.UserCustomCategory;
import com.custom.foodbill.models.records.UserCustomKey;
import com.custom.foodbill.services.UserCustomKeyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/custom_key")
public class UserCustomKeyController {

    private final UserCustomKeyService userCustomKeyService;

    public UserCustomKeyController(UserCustomKeyService userCustomKeyService) {
        this.userCustomKeyService = userCustomKeyService;
    }

    @RequestMapping("/test")
    public Flux<UserCustomKey> test() {
        return userCustomKeyService.getDefaultProp(UserCustomCategory.MEAL_TIME);
    }

//    public Flux<UserCustomKey> addOrUpdateUserCustomKeys() {
//
//    }

    @RequestMapping("/getDefaultProp")
    public Flux<UserCustomKey> getDefaultProp(@RequestBody UserCustomCategory userCustomCategory) {
        return userCustomKeyService.getDefaultProp(userCustomCategory);
    }
    @RequestMapping("/getUserCustomKeyByUserCustomCategory")
    public Flux<UserCustomKey> getUserCustomKeyByUserCustomCategory(@RequestBody UserCustomCategory userCustomCategory) {
        return userCustomKeyService.getUserCustomKeyByUserCustomCategory(userCustomCategory);
    }
}
