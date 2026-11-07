package com.example.Challenge.domain.models.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Restaurants {

    private Long id;
    private String name;

    private String address;

    private String telephone;

    private String urlLogo;

    private String nit;

    private Long iduserpropetary;

    private String namepropetary;

}
