package com.example.Challenge.infrastructure.adapter.repository.rols;

import com.example.Challenge.domain.models.rols.Rols;
import com.example.Challenge.domain.ports.IRolsRepositoryPort;
import com.example.Challenge.infrastructure.adapter.entity.EntityRol;
import com.example.Challenge.infrastructure.exception.Rol.RolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RolsRepositoryAdapter implements IRolsRepositoryPort {

    private final IRolsRepositoryAdapter rolsRepositoryAdapter;
    @Override
    public Rols save(Rols rols){

        //Convercion a jpa
       EntityRol entityToSave = EntityRol.builder()
                .name(rols.getName())
                .description(rols.getDescription())
                .build();

        EntityRol savedEntity  = rolsRepositoryAdapter.save(entityToSave);

        return Rols.builder().
                id(savedEntity.getId())
                .name(savedEntity.getName())
                .description(savedEntity.getDescription())
                .build();

    }

    @Override
    public Rols findById(Long id){

        EntityRol entityRolId = rolsRepositoryAdapter.findById(id).orElseThrow(() ->
                new RolNotFoundException("Rol no encontrado"));

        return Rols.builder()
                .id(entityRolId.getId())
                .name(entityRolId.getName())
                .description(entityRolId.getDescription())
                .build();

    }

    @Override
    public List<Rols> findAll(){

       return rolsRepositoryAdapter.findAll()
               .stream()
               .map(entityRol -> new Rols(
                       entityRol.getId(),
                       entityRol.getName(),
                       entityRol.getDescription()))
                .toList();

    }

    @Override
    public Optional<Rols> update(Long id, Rols rols){

        if (rolsRepositoryAdapter.existsById(id)) {

            EntityRol entityToSave = EntityRol.builder()
                    .id(id)
                    .name(rols.getName())
                    .description(rols.getDescription())
                    .build();

            EntityRol savedEntity = rolsRepositoryAdapter.save(entityToSave);

            Rols rolActualizado = Rols.builder()
                    .id(savedEntity.getId())
                    .name(savedEntity.getName())
                    .description(savedEntity.getDescription())
                    .build();

            return Optional.of(rolActualizado);
        }

        return Optional.empty();

    }



}
