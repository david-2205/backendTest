package com.example.Challenge.infrastructure.entryEndpoint.dto.Rol;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RolResponse {

    private Long id;
    private String name;
    private String description;

}
