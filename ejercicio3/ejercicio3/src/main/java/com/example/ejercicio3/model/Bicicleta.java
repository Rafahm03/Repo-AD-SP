package com.example.ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
    private String marca;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "estacion_id", nullable = true)
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Uso> usos = new ArrayList<>();

    public void addUso(Uso uso) {
        usos.add(uso);
        uso.setBicicleta(this);
    }

    public void removeUso(Uso uso) {
        usos.remove(uso);
        uso.setBicicleta(null);
    }
}