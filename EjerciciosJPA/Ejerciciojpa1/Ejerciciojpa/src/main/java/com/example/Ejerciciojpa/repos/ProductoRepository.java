package com.example.Ejerciciojpa.repos;

import com.example.Ejerciciojpa.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
