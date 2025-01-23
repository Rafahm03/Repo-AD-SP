package com.example.EjemploUsoHerencias1.reposingletable;

import com.example.EjemploUsoHerencias1.modelsingletable.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
