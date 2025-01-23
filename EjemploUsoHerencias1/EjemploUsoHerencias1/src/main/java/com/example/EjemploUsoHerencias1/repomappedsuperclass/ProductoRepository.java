package com.example.EjemploUsoHerencias1.repomappedsuperclass;

import com.example.EjemploUsoHerencias1.modelmappedsuperclass.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
