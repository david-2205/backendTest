package com.example.Challenge.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")


public class EntityRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String telephone;

    private String urlLogo;

    private String nit;

    @ManyToOne
    @JoinColumn(name = "iduserpropetary", nullable = false)
    private EntityUser user;

}
