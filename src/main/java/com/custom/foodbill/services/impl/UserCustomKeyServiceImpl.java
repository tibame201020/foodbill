package com.custom.foodbill.services.impl;

import com.custom.foodbill.constants.UserCustomCategory;
import com.custom.foodbill.models.records.UserCustomKey;
import com.custom.foodbill.repos.UserCustomKeyRepo;
import com.custom.foodbill.services.UserCustomKeyService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static com.custom.foodbill.constants.ArgConstants.DEFAULT_FOOD_PROPS;
import static com.custom.foodbill.constants.ArgConstants.DEFAULT_MEAL_TIMES;

@Service
public class UserCustomKeyServiceImpl implements UserCustomKeyService {
    private final UserCustomKeyRepo userCustomKeyRepo;

    public UserCustomKeyServiceImpl(UserCustomKeyRepo userCustomKeyRepo) {
        this.userCustomKeyRepo = userCustomKeyRepo;
    }

    @Override
    public Flux<UserCustomKey> getDefaultProp(UserCustomCategory userCustomCategory) {
        switch (userCustomCategory) {
            case MEAL_TIME -> {
                return Flux.fromArray(DEFAULT_MEAL_TIMES)
                        .map(prop -> new UserCustomKey(prop, userCustomCategory));
            }
            case FOOD_PROP -> {
                return Flux.fromArray(DEFAULT_FOOD_PROPS)
                        .map(prop -> new UserCustomKey(prop, userCustomCategory));
            }
            default -> {
                return Flux.empty();
            }
        }
    }

    @Override
    public Flux<UserCustomKey> getUserCustomKeyByUserCustomCategory(UserCustomCategory userCustomCategory) {
        return userCustomKeyRepo
                .findAllByUserCustomCategory(userCustomCategory)
                .switchIfEmpty(Flux.defer(() -> getDefaultProp(userCustomCategory)));
    }
}
