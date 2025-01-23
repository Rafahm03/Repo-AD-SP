package com.example.EjemploUsoHerencias1.modeljoined;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(callSuper = true)
public class Profesor extends Persona {

    private String asignatura;
    private String departamento;

    public Profesor(Long id, String nombre, String apellido, String asignatura, String departamento) {
        super(id, nombre, apellido);
        this.asignatura = asignatura;
        this.departamento = departamento;
    }

}
