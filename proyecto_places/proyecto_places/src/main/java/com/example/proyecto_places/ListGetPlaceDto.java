package com.example.proyecto_places;

import java.util.List;

import static java.util.stream.Collectors.toList;

public record ListGetPlaceDto (
        long count,
        List<Object> items
    ){

        public static ListGetPlaceDto listGetPlaceDto(List<Place> list){
            return new ListGetPlaceDto(
                    list.size(),
                    list.stream().map(PlaceDto::of).toList()
            );
        }
}
