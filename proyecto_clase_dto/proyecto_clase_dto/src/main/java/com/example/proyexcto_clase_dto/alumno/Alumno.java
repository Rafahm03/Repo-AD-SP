package com.example.proyexcto_clase_dto.alumno;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String correo;
    private int curso;
}

