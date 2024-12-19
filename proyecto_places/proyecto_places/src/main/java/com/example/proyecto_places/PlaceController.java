package com.example.proyecto_places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/")
    public ResponseEntity<List<Place>> listarLugares() {
        List<Place> places = placeService.listarLugares();
        if (places.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(places);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> listarPorId(@PathVariable Long id) {
        Place place = placeService.obtenerLugar(id).orElse(null);
        if (place == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(place);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Place> crearLugar(@RequestBody CreatePlaceDto dto) {
        return ResponseEntity.status(201).body(
                placeService.anyadir(dto.toPlace())
        );
    }

    @PutMapping("/{id}")
    public Place editarLugar(@PathVariable Long id, @RequestBody CreatePlaceDto dto) {
        return placeService.editarLugar(id, dto.toPlace());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLugar(@PathVariable Long id) {
        placeService.eliminarLugar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/tag/{tag}")
    public ResponseEntity<Place> agregarTag(@PathVariable Long id, @PathVariable String tag) {
        Place place = placeService.agregarTag(id, tag).orElse(null);
        if (place == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(place);
        }
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Place> eliminarTag(@PathVariable Long id, @PathVariable String tag) {
        Place place = placeService.eliminarTag(id, tag).orElse(null);
        if (place == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(place);
        }
    }
}