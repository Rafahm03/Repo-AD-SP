package com.example.EjemploUsoHerencias1.repomappedsuperclass;

import com.example.EjemploUsoHerencias1.modelmappedsuperclass.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
