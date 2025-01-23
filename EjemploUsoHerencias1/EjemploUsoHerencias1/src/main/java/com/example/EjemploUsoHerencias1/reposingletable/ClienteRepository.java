package com.example.EjemploUsoHerencias1.reposingletable;

import com.example.EjemploUsoHerencias1.modelsingletable.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
