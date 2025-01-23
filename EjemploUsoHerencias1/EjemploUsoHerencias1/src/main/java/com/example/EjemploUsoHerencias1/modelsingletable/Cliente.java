package com.example.EjemploUsoHerencias1.modelsingletable;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Cliente extends Usuario {
    private String telefono;

    public Cliente(Long id, String fullName, String username, String telefono) {
        super(id, fullName, username);
        this.telefono = telefono;

    }
}

