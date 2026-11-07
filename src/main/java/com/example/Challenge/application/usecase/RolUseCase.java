package com.example.Challenge.application.usecase;

import com.example.Challenge.domain.models.rols.Rols;
import com.example.Challenge.domain.ports.IRolsRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolUseCase {

    private final IRolsRepositoryPort rolsRepositoryPort;
    public Rols save(Rols rols){

        return rolsRepositoryPort.save(rols);

    }

    public Rols findById(Long id){
        return rolsRepositoryPort.findById(id);
    }

    public List<Rols> findAll(){
        return rolsRepositoryPort.findAll();
    }

    public Optional<Rols> update(Long id, Rols rols){
        return rolsRepositoryPort.update(id, rols);
    }

}
