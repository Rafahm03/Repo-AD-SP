package com.example.ejercicio3.repo;

import com.example.ejercicio3.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {

    List<Bicicleta> buscarMismoModelo(String modelo);

    List<Bicicleta> getAllByModelo(String modelo);

    List<Bicicleta> getAllByMarcaAndEstado(String marca, String estado);
}
