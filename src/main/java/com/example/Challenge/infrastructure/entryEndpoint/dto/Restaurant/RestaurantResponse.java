package com.example.Challenge.infrastructure.entryEndpoint.dto.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantResponse {

    private Long id;
    private String name;
    private String address;
    private String telephone;
    private String urlLogo;
    private String nit;
    private Long iduserpropetary;
    private String namepropetary;

}
