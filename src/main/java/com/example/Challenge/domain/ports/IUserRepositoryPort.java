package com.example.Challenge.domain.ports;


import com.example.Challenge.domain.models.users.Users;

public interface IUserRepositoryPort {

   Users save(Users users);

   boolean existsByNumberDocument(String numberDocument);

}
