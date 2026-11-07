package com.example.Challenge.infrastructure.entryEndpoint.dto.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
public class UserRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastname;

    @NotBlank(message = "El numero de documento es obligatorio")
    @Pattern(regexp = "^\\d+$", message = "El campo numero de documento debe contener solo números")
    private String numberDocument;

    @NotBlank(message = "El numero de celular es obligatorio")
    @Pattern(regexp = "^\\d+$", message = "El campo celular debe contener solo números")
    private String telephone;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    private String email;
    private String password;

    @NotNull(message = "El identificador del rol es obligatorio.")
    //@Positive(message = "El identificador debe ser un número positivo.")
    //@Pattern(regexp = "^\\d+$", message = "El identificador debe contener solo números")
    private Long idRol;


}
