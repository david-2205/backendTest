package com.example.Challenge.infrastructure.entryEndpoint.dto.Rol;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolRequest {

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String name;
    @NotBlank(message = "La descripcion del rol es obligatorio")
    private String description;

}
