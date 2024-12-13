package com.salesianos.triana.dam.monumentos_v2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {


    private long id;

    @Column(name = "cod_Pais")
    private String codPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    private String descripcion;
    private String imagen;
}
