package com.custom.foodbill.repos;

import com.custom.foodbill.models.records.UserCustomKey;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserCustomKeyRepo extends ReactiveMongoRepository<UserCustomKey, UserCustomKey> {
}
