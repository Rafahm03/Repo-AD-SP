package com.example.ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Uso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double coste;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id", nullable = false)
    private Bicicleta bicicleta;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null && !usuario.getUsos().contains(this)) {
            usuario.getUsos().add(this);
        }
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
        if (bicicleta != null && !bicicleta.getUsos().contains(this)) {
            bicicleta.getUsos().add(this);
        }
    }
}