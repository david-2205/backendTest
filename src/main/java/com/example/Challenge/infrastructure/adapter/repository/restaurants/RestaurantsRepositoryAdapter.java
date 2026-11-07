package com.example.Challenge.infrastructure.adapter.repository.restaurants;

import com.example.Challenge.domain.models.restaurant.Restaurants;
import com.example.Challenge.domain.models.users.Users;
import com.example.Challenge.domain.ports.IRestaurantRepositoryPort;
import com.example.Challenge.infrastructure.adapter.entity.EntityRestaurant;
import com.example.Challenge.infrastructure.adapter.entity.EntityRol;
import com.example.Challenge.infrastructure.adapter.entity.EntityUser;
import com.example.Challenge.infrastructure.adapter.repository.restaurants.IRestaurantsRepositoryAdapter;
import com.example.Challenge.infrastructure.adapter.repository.users.IUserRepositoryAdapter;
import com.example.Challenge.infrastructure.exception.Rol.RolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class RestaurantsRepositoryAdapter implements IRestaurantRepositoryPort {

    private final IRestaurantsRepositoryAdapter restaurantsRepositoryAdapter;
    private final IUserRepositoryAdapter userRepositoryAdapter;

    @Override
    public Restaurants save(Restaurants restaurants){

        EntityUser entityUserId = userRepositoryAdapter.findById(restaurants.getIduserpropetary()).orElseThrow(() ->
                new RolNotFoundException("Usuario no encontrado"));

        EntityRestaurant entityRestaurant = EntityRestaurant.builder()
                .name(restaurants.getName())
                .telephone(restaurants.getTelephone())
                .address(restaurants.getAddress())
                .nit(restaurants.getNit())
                .urlLogo(restaurants.getUrlLogo())
                .user(entityUserId)
                .build();

        EntityRestaurant saveEntity= restaurantsRepositoryAdapter.save(entityRestaurant);

        return Restaurants.builder()
                .id(saveEntity.getId())
                .name(saveEntity.getName())
                .telephone(saveEntity.getTelephone())
                .address(saveEntity.getAddress())
                .nit(saveEntity.getNit())
                .urlLogo(saveEntity.getUrlLogo())
                .iduserpropetary(saveEntity.getUser().getId())
                .namepropetary(saveEntity.getUser().getName())
                .build();

    }

}
