package com.example.ejercicio3.dto;

import com.example.ejercicio3.model.Estacion;

public record GetEstacionCmd(Long id, String nombre, int numero, String coordenadas, int capacidad  ) {
    public static GetEstacionCmd of(Estacion estacion){
        return new GetEstacionCmd(estacion.getId(), estacion.getNombre(), estacion.getNumero(), estacion.getCoordenadas(), estacion.getCapacidad());
    }
}
