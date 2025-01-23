package com.example.EjemploUsoHerencias1.reposingletable;

import com.example.EjemploUsoHerencias1.modelsingletable.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
