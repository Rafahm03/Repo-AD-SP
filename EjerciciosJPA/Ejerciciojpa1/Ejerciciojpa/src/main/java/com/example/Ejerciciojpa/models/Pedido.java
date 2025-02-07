package com.example.Ejerciciojpa.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private LocalDateTime fecha = LocalDateTime.now();

    private String cliente;

    @OneToMany


}
