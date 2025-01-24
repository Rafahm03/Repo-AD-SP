package com.example.ejercicio3.service;

import com.example.ejercicio3.dto.EditEstacionDto;
import com.example.ejercicio3.model.Estacion;
import com.example.ejercicio3.repo.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {


    private final EstacionRepository estacionRepository;


    public List<Estacion> findAll(){
        List<Estacion> estaciones = estacionRepository.findAll();
        if (estaciones.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones");
        }
        return estaciones;
    }


    public Estacion findById(Long id){
        Optional<Estacion> estacionesOp = estacionRepository.findById(id);
        if (estacionesOp.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado estaciones con ese id");
        }
        return estacionesOp.get();
    }


    public Estacion save(EditEstacionDto dto) {
        return estacionRepository.save(Estacion.builder()
                .nombre(dto.nombre())
                .numero(dto.numero())
                .coordenadas(dto.coordenadas())
                .capacidad(dto.capacidad())
                .build());
    }


    public Estacion update(Long id, EditEstacionDto dto) {
        return estacionRepository.findById(id)
                .map(old -> {
                    old.setNombre(dto.nombre());
                    old.setNumero(dto.numero());
                    old.setCapacidad(dto.capacidad());
                    old.setCoordenadas(dto.coordenadas());
                    return estacionRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se han encontrado estaciones con el id " + id));

    }


    public void deleteById(Long id) {
        Optional<Estacion> estacionOpId = estacionRepository.findById(id);
        if (estacionOpId.isEmpty()) {
            throw new EntityNotFoundException("No se ha encontrado una estación con el ID proporcionado");
        }
        estacionRepository.deleteById(id);
    }
}