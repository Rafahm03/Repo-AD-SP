package com.example.EjemploUsoHerencias1.repojoined;

import com.example.EjemploUsoHerencias1.modeljoined.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
