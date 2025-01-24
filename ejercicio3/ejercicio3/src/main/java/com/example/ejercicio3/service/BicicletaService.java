package com.example.ejercicio3.service;

import com.example.ejercicio3.dto.EditBicicletaDto;
import com.example.ejercicio3.model.Bicicleta;
import com.example.ejercicio3.repo.BicicletaRepository;
import com.example.ejercicio3.repo.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;

    public List<Bicicleta> findAllBicicleta(){
        List<Bicicleta> bibicletas = bicicletaRepository.findAll();
        if (bibicletas.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones");
        }
        return bibicletas;

    }

    public Bicicleta findBicicleta(Long id){
        Optional<Bicicleta> bicicletasOp = bicicletaRepository.findById(id);
        if (bicicletasOp.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones con ese id");
        }
        return bicicletasOp.get();

    }

    public Bicicleta save(EditBicicletaDto nuevo){
        return bicicletaRepository.save(Bicicleta.builder()
                .marca(nuevo.marca())
                .modelo(nuevo.modelo())
                .estado(nuevo.estado())
                .build());
    }

    public Bicicleta edit(EditBicicletaDto editBicicletaDto, Long id) {
        return bicicletaRepository.findById(id)
                .map(old -> {
                    old.setMarca(editBicicletaDto.marca());
                    old.setEstado(editBicicletaDto.estado());
                    old.setModelo(editBicicletaDto.modelo());
                    return bicicletaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay bibicletas con ID: "+ id));

    }

    public void delete(Long id){
        bicicletaRepository.deleteById(id);
    }
}
