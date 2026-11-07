package com.example.Challenge.infrastructure.adapter.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "users")
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String lastname;
    @Column(name = "number_document", unique = true)
    private String numberDocument;
    private String telephone;
    private LocalDate date_of_birth;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private EntityRol rol;

}
