package com.example.proyecto_places;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(String message) {
        super(message);
    }
}
