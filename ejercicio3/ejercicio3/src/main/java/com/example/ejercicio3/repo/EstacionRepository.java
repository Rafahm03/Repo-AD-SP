package com.example.ejercicio3.repo;

import com.example.ejercicio3.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion, Long> {
}
