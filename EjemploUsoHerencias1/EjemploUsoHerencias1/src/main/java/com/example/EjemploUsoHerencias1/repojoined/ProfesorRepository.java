package com.example.EjemploUsoHerencias1.repojoined;

import com.example.EjemploUsoHerencias1.modeljoined.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
