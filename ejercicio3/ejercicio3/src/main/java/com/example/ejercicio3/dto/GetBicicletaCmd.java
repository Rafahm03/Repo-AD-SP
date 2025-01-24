package com.example.ejercicio3.dto;

import com.example.ejercicio3.model.Bicicleta;

public record GetBicicletaCmd(
        Long id,
        String marca,
        String modelo,
        GetEstacionCmd estacion
) {
    public static GetBicicletaCmd of(Bicicleta b){
        return new GetBicicletaCmd(
                b.getId(),
                b.getMarca(),
                b.getModelo(),
                GetEstacionCmd.of(b.getEstacion())

        );
    }
}
