package com.example.ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String numTarjeta;
    private int pin;
    private double saldo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Uso> usos = new ArrayList<>();

    public void addUso(Uso uso) {
        usos.add(uso);
        uso.setUsuario(this);
    }

    public void removeUso(Uso uso) {
        usos.remove(uso);
        uso.setUsuario(null);
    }
}