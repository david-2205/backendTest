package com.example.Challenge.infrastructure.adapter.repository.restaurants;

import com.example.Challenge.infrastructure.adapter.entity.EntityRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantsRepositoryAdapter extends JpaRepository<EntityRestaurant, Long> {



}
