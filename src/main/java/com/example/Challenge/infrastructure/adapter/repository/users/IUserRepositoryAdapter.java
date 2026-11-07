package com.example.Challenge.infrastructure.adapter.repository.users;

import com.example.Challenge.domain.models.users.Users;
import com.example.Challenge.infrastructure.adapter.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepositoryAdapter extends JpaRepository<EntityUser, Long> {

    boolean existsByNumberDocument(String numberDocument);

}
