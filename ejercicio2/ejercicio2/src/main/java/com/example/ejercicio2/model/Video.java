package com.example.ejercicio2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@IdClass(VideoPk.class)
public class Video {


    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private CursoOnline cursoOnline;

    private int orden;

    private String descripcion;

    private String url;


}
