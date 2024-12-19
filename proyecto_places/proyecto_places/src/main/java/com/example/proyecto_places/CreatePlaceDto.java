package com.example.proyecto_places;

public record CreatePlaceDto(
        String nombre,
        String address,
        String coords,
        String images
) {
    public Place toPlace(){
        return Place.builder()
                .name(this.nombre())
                .address(this.address())
                .coords(this.coords())
                .image(this.images())
                .build();
    }
}
