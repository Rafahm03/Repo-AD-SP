package com.example.ejercicio2.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Profesor {


    @Id
    @GeneratedValue
    private Long id;


    private String nombre;

    private String email;

    private double puntuacion;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "profesor", fetch =
    FetchType.EAGER)
    private List<CursoOnline> cursos = new ArrayList<>();


    public void addCursoOnline(CursoOnline curso){
        curso.setProfesor(this);
        this.cursos.add(curso);
    }

    public void deletecursoOnline(){

    }
}
