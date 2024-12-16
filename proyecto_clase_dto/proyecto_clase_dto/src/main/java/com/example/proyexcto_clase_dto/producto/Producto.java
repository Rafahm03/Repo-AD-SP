package com.example.proyexcto_clase_dto.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private int precio;
    private List<String> imagenes ;
    private Categoria categoria;
}
