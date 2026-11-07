package com.example.Challenge.domain.models.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Users {

    private Long id;
    private String name;
    private String lastname;

    private String numberDocument;

    private String telephone;

    private LocalDate date_of_birth;

    private String email;

    private String password;

    private Long idRol;

    private String nameRol;

}
