package com.example.ejercicio2.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoPk implements Serializable {
    private Long id;
    private CursoOnline cursoOnline;
}
