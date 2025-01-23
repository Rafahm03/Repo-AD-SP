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
public class Admin extends Usuario{
    public Admin(Long id, String fullName, String username) {
        super(id, fullName, username);
    }

}
