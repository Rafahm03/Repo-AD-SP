package com.example.ejercicioDto.producto;

public record ProductoDto(
        String nombre,
        double pvp,
        String imagen,
        String categoria

) {

public static ProductoDto fromProducto(Producto producto) {
    return new ProductoDto(
            producto.getNombre(),
            producto.getPvp(),
            producto.getImagenPrincipal(),
            producto.getCategoria().getNombre()
    );
}
}
