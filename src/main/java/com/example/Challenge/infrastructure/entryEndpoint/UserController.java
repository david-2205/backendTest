package com.example.Challenge.infrastructure.entryEndpoint;

import com.example.Challenge.application.usecase.UserUseCase;
import com.example.Challenge.domain.models.users.Users;
import com.example.Challenge.infrastructure.entryEndpoint.dto.User.UserRequest;
import com.example.Challenge.infrastructure.entryEndpoint.dto.User.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor

public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest){

        Users users = Users.builder()
                .name(userRequest.getName())
                .lastname(userRequest.getLastname())
                .numberDocument(userRequest.getNumberDocument())
                .telephone(userRequest.getTelephone())
                .date_of_birth(userRequest.getDate_of_birth())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .idRol(userRequest.getIdRol())
                .build();

        Users saveUser = userUseCase.save(users);

        UserResponse response = UserResponse.builder()
                .id(saveUser.getId())
                .name(saveUser.getName())
                .lastname(saveUser.getLastname())
                .numberDocument(saveUser.getNumberDocument())
                .date_of_birth(saveUser.getDate_of_birth())
                .email(saveUser.getEmail())
                .password(saveUser.getPassword())
                .idRol(saveUser.getIdRol())
                .nameRol(saveUser.getNameRol())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);


    }

}
