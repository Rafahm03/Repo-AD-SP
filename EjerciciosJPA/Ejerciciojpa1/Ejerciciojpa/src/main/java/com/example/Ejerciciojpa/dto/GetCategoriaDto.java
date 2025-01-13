package com.example.Ejerciciojpa.dto;

import com.example.Ejerciciojpa.models.Categoria;

public record GetCategoriaDto(Long id, String nombre) {

    public static GetCategoriaDto of(Categoria categoria) {
        return new GetCategoriaDto(categoria.getId(), categoria.getNombre());
    }




}