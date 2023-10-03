package com.custom.foodbill.repos;

import com.custom.foodbill.constants.UserCustomCategory;
import com.custom.foodbill.models.records.UserCustomKey;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserCustomKeyRepo extends ReactiveMongoRepository<UserCustomKey, UserCustomKey> {
    Flux<UserCustomKey> findAllByUserCustomCategory(UserCustomCategory userCustomCategory);
}
