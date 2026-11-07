package com.example.Challenge.infrastructure.entryEndpoint;

import com.example.Challenge.application.usecase.RestaurantUseCase;
import com.example.Challenge.domain.models.restaurant.Restaurants;
import com.example.Challenge.infrastructure.entryEndpoint.dto.Restaurant.RestaurantRequest;
import com.example.Challenge.infrastructure.entryEndpoint.dto.Restaurant.RestaurantResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantUseCase restaurantUseCase;

    @PostMapping("/saveRestaurant")
    public ResponseEntity<RestaurantResponse> save(@Valid @RequestBody RestaurantRequest restaurantRequest){

        Restaurants restaurants = Restaurants.builder()
                .name(restaurantRequest.getName())
                .address(restaurantRequest.getAddress())
                .nit(restaurantRequest.getNit())
                .telephone(restaurantRequest.getTelephone())
                .urlLogo(restaurantRequest.getUrlLogo())
                .iduserpropetary(restaurantRequest.getIduserpropetary())
                .build();

        Restaurants saveRestaurant = restaurantUseCase.save(restaurants);

        RestaurantResponse response = RestaurantResponse.builder()
                .id(saveRestaurant.getId())
                .name(saveRestaurant.getName())
                .address(saveRestaurant.getAddress())
                .nit(saveRestaurant.getNit())
                .telephone(saveRestaurant.getTelephone())
                .urlLogo(saveRestaurant.getUrlLogo())
                .iduserpropetary(saveRestaurant.getIduserpropetary())
                .namepropetary(saveRestaurant.getNamepropetary())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);


    }

}
