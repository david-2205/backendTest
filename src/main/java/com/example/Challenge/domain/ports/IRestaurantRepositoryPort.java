package com.example.Challenge.domain.ports;


import com.example.Challenge.domain.models.restaurant.Restaurants;

public interface IRestaurantRepositoryPort {

   Restaurants save(Restaurants restaurants);

}
