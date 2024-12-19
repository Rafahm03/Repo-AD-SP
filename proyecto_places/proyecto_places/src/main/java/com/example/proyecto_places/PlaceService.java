package com.example.proyecto_places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place anyadir(Place place) {
        return placeRepository.add(place);
    }

    public List<Place> listarLugares() {
        if (placeRepository.getAll().isEmpty()) {
            throw new PlaceNotFoundException("No hay lugares");
        } else {
            return placeRepository.getAll();
        }
    }

    public Optional<Place> obtenerLugar(Long id) {
        return Optional.ofNullable(placeRepository.get(id)
                .orElseThrow(() -> new PlaceNotFoundException(
                        "No se ha encontrado el lugar".formatted(id)
                ))
        );
    }

    public Place editarLugar(Long id, Place place) {
        return placeRepository.edit(id, place).orElseThrow(() -> new PlaceNotFoundException(
                "No se ha encontrado el lugar".formatted(id)
        ));
    }

    public boolean eliminarLugar(Long id) {
        if (placeRepository.get(id).isPresent()) {
            placeRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    public Optional<Place> agregarTag(Long id, String tag) {
        Optional<Place> place = placeRepository.get(id);
        if(place.isPresent()){
            place.get().addTag(tag);
            placeRepository.edit(id, place.get());
        }
        return place;
    }

    public Optional<Place> eliminarTag(Long id, String tag) {
        Optional<Place> place = placeRepository.get(id);
        if (place.isPresent()) {
            place.get().removeTag(tag);
            placeRepository.edit(id, place.get());
        }
        return place;
    }
}