package com.custom.foodbill.repos;

import com.custom.foodbill.models.food.Food;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FoodRepo extends ReactiveMongoRepository<Food, String> {
}
