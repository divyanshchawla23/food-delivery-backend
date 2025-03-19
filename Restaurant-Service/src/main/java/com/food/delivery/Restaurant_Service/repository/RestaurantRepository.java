package com.food.delivery.Restaurant_Service.repository;

import com.food.delivery.Restaurant_Service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCuisineType(String cuisineType);
}
