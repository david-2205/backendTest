package com.example.Challenge.application.usecase;

import com.example.Challenge.domain.models.restaurant.Restaurants;
import com.example.Challenge.domain.ports.IRestaurantRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantUseCase {

    private final IRestaurantRepositoryPort restaurantRepositoryPort;

    public Restaurants save(Restaurants restaurants){
        return restaurantRepositoryPort.save(restaurants);
    }

}
