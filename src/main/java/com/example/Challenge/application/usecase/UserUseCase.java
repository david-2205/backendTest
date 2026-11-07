package com.example.Challenge.application.usecase;


import com.example.Challenge.domain.models.users.Users;
import com.example.Challenge.domain.ports.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase {

    private final IUserRepositoryPort userRepositoryPort;

    public Users save(Users users){
        return userRepositoryPort.save(users);
    }

    public boolean existsByNumberDocument(String numberDocument){
        return userRepositoryPort.existsByNumberDocument(numberDocument);
    }

}
