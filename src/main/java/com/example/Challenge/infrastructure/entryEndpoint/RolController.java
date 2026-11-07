package com.example.Challenge.infrastructure.entryEndpoint;

import com.example.Challenge.application.usecase.RolUseCase;
import com.example.Challenge.domain.models.rols.Rols;
import com.example.Challenge.infrastructure.entryEndpoint.dto.Rol.RolRequest;
import com.example.Challenge.infrastructure.entryEndpoint.dto.Rol.RolResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor

public class RolController {

private final RolUseCase rolUseCase;

    @PostMapping("/saveRol")
    public ResponseEntity<RolResponse> create(@Valid @RequestBody RolRequest request){

        Rols rol = Rols.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Rols savedRol=rolUseCase.save(rol);

        RolResponse response = RolResponse.builder()
                .id(savedRol.getId())
                .name(savedRol.getName())
                .description(savedRol.getDescription())
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> findById(@PathVariable Long id) {

        Rols rol = rolUseCase.findById(id);

        RolResponse response = RolResponse.builder()
                .id(rol.getId())
                .name(rol.getName())
                .description(rol.getDescription())
                .build();

        return ResponseEntity.ok(response);

    }


    @GetMapping("/getDataRol")
    public ResponseEntity<List<RolResponse>> findAll(){

       List<Rols> getRol=  rolUseCase.findAll();

        List<RolResponse> response = getRol.stream()
                .map(rol -> RolResponse.builder()
                        .id(rol.getId())
                        .name(rol.getName())
                        .description(rol.getDescription())
                        .build())
                .toList();

        return ResponseEntity.ok(response);

    }

    @PutMapping("/{rolId}")
    public ResponseEntity<Rols> update(@PathVariable("rolId") Long id, @RequestBody Rols rols) {
        return rolUseCase.update(id, rols)
                .map(rols1 -> new ResponseEntity<>(rols1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
