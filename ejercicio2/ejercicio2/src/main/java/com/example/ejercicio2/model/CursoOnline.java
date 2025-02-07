package com.example.ejercicio2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;


}
