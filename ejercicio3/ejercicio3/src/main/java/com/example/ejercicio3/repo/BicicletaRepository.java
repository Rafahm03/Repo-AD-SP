package com.example.ejercicio3.repo;

import com.example.ejercicio3.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
}
