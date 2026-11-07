package com.example.Challenge.infrastructure.adapter.repository.users;

import com.example.Challenge.domain.models.rols.Rols;
import com.example.Challenge.domain.models.users.Users;
import com.example.Challenge.domain.ports.IUserRepositoryPort;
import com.example.Challenge.infrastructure.adapter.entity.EntityRol;
import com.example.Challenge.infrastructure.adapter.entity.EntityUser;
import com.example.Challenge.infrastructure.adapter.repository.rols.IRolsRepositoryAdapter;
import com.example.Challenge.infrastructure.exception.Rol.RolNotFoundException;
import com.example.Challenge.infrastructure.exception.User.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryAdapter implements IUserRepositoryPort {

    private final IUserRepositoryAdapter userRepositoryAdapter;
    private final IRolsRepositoryAdapter rolsRepositoryAdapter;

    @Override
    public Users save(Users users){

        EntityRol entityRolId = rolsRepositoryAdapter.findById(users.getIdRol()).orElseThrow(() ->
                new RolNotFoundException("Rol no encontrado"));

        if (userRepositoryAdapter.existsByNumberDocument(users.getNumberDocument())) {
            throw new UserAlreadyExistsException("El numero de documento ya se encuentra registrado");
        }

        EntityUser entityUser = EntityUser.builder()
                .name(users.getName())
                .lastname(users.getLastname())
                .numberDocument(users.getNumberDocument())
                .telephone(users.getTelephone())
                .date_of_birth(users.getDate_of_birth())
                .email(users.getEmail())
                .password(users.getPassword())
                .rol(entityRolId)
                .build();

        EntityUser saveEntity= userRepositoryAdapter.save(entityUser);

        return Users.builder().
                id(saveEntity.getId())
                .name(saveEntity.getName())
                .lastname(saveEntity.getLastname())
                .numberDocument(saveEntity.getNumberDocument())
                .telephone(saveEntity.getTelephone())
                .date_of_birth(saveEntity.getDate_of_birth())
                .email(saveEntity.getEmail())
                .password(saveEntity.getPassword())
                .idRol(saveEntity.getRol().getId())
                .nameRol(saveEntity.getRol().getName())
                .build();

    }

@Override
    public boolean existsByNumberDocument(String numberDocument){
        return userRepositoryAdapter.existsByNumberDocument(numberDocument);
    }


}


