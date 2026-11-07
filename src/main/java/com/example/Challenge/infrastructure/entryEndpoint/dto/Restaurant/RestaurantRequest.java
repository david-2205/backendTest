package com.example.Challenge.infrastructure.entryEndpoint.dto.Restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantRequest {

        @NotBlank(message = "El nombre es obligatorio")
        private String name;

        @NotBlank(message = "La direccion es obligatorio")
        private String address;

        @NotBlank(message = "El telefono es obligatorio")
        private String telephone;

        @NotBlank(message = "La url es obligatorio")
        private String urlLogo;

        @NotBlank(message = "El nit es obligatorio")
        private String nit;

        @NotNull(message = "El identificador del propietario es obligatorio.")
        private Long iduserpropetary;



}
