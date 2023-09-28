package com.custom.foodbill.repos;

import com.custom.foodbill.models.records.FoodInTakeRecord;
import com.custom.foodbill.models.records.FoodInTakeRecordPk;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FoodInTakeRecordRepo extends ReactiveMongoRepository<FoodInTakeRecord, FoodInTakeRecordPk> {
}
