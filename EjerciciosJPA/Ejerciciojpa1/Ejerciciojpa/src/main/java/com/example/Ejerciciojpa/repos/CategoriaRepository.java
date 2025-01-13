package com.example.Ejerciciojpa.repos;

import com.example.Ejerciciojpa.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
