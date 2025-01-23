package com.example.EjemploUsoHerencias1.modelmappedsuperclass;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Monitor extends Producto{

    private String tipoPantalla;
    private String modelo;

    public Monitor(Long id, String nombre, String descripcion, String tipoPantalla, String modelo) {
        super(id, nombre, descripcion);
        this.tipoPantalla = tipoPantalla;
        this.modelo = modelo;
    }


}
