package com.example.EjemploUsoHerencias1.modelmappedsuperclass;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@SuperBuilder
public class Monitor extends Producto{

    private String tipoPantalla;
    private String modelo;



}
