package com.example.Ejerciciojpa.dto;

public record EditProductoCmd(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) {
}