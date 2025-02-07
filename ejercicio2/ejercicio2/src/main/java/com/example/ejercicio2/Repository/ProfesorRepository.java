package com.example.ejercicio2.Repository;

import com.example.ejercicio2.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
