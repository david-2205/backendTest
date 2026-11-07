package com.example.Challenge.domain.ports;

import com.example.Challenge.domain.models.rols.Rols;

import java.util.List;
import java.util.Optional;

public interface IRolsRepositoryPort {

    Rols save(Rols rols);
    //public void save(Rols rols);

    Rols findById(Long id);

    List<Rols> findAll();

    Optional<Rols> update(Long id, Rols rols);


}
