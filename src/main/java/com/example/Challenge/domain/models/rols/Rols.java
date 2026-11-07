package com.example.Challenge.domain.models.rols;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Rols {

    private Long id;
    private String name;
    private String description;

}
