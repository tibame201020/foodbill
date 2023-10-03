package com.custom.foodbill.services;

import com.custom.foodbill.constants.UserCustomCategory;
import com.custom.foodbill.models.records.UserCustomKey;
import com.custom.foodbill.repos.UserCustomKeyRepo;
import com.custom.foodbill.services.impl.UserCustomKeyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static com.custom.foodbill.constants.ArgConstants.DEFAULT_FOOD_PROPS;
import static com.custom.foodbill.constants.ArgConstants.DEFAULT_MEAL_TIMES;

@ExtendWith(MockitoExtension.class)
class UserCustomKeyServiceTest {
    @InjectMocks
    private UserCustomKeyServiceImpl userCustomKeyService;
    @Mock
    private UserCustomKeyRepo userCustomKeyRepo;

    @Test
    void getDefaultProp_MEALTIMES() {
        UserCustomCategory userCustomCategory = UserCustomCategory.MEAL_TIME;
        String expect1 = DEFAULT_MEAL_TIMES[0];
        String expect2 = DEFAULT_MEAL_TIMES[1];
        String expect3 = DEFAULT_MEAL_TIMES[2];

        Flux<String> result =
                userCustomKeyService
                        .getDefaultProp(userCustomCategory)
                        .log()
                        .map(UserCustomKey::getName);

        StepVerifier.create(result)
                .expectNext(expect1, expect2, expect3)
                .verifyComplete();
    }

    @Test
    void getDefaultProp_FOODPROPS() {
        UserCustomCategory userCustomCategory = UserCustomCategory.FOOD_PROP;
        String expect1 = DEFAULT_FOOD_PROPS[0];
        String expect2 = DEFAULT_FOOD_PROPS[1];
        String expect3 = DEFAULT_FOOD_PROPS[2];
        String expect4 = DEFAULT_FOOD_PROPS[3];
        String expect5 = DEFAULT_FOOD_PROPS[4];
        String expect6 = DEFAULT_FOOD_PROPS[5];
        String expect7 = DEFAULT_FOOD_PROPS[6];

        Flux<String> result =
                userCustomKeyService
                        .getDefaultProp(userCustomCategory)
                        .log()
                        .map(UserCustomKey::getName);

        StepVerifier.create(result)
                .expectNext(expect1, expect2, expect3, expect4, expect5, expect6, expect7)
                .verifyComplete();
    }

    @Test
    void getUserCustomKeyByUserCustomCategory() {
        UserCustomCategory userCustomCategory = UserCustomCategory.MEAL_TIME;
        String expect = "other_time";
        Mockito.when(userCustomKeyRepo.findAllByUserCustomCategory(userCustomCategory))
                .thenReturn(Flux.just(new UserCustomKey(expect, UserCustomCategory.MEAL_TIME)));

        Flux<String> result =
                userCustomKeyService
                        .getUserCustomKeyByUserCustomCategory(userCustomCategory)
                        .log()
                        .map(UserCustomKey::getName);

        StepVerifier.create(result)
                .expectNext(expect)
                .verifyComplete();
    }
}