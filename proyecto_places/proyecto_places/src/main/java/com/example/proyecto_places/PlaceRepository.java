package com.example.proyecto_places;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class PlaceRepository {
    private Map<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Place.builder()
                .name("Bar el Rafa")
                .address("C/Juan Díaz De Solís N13")
                .coords("11N 32º 45")
                .desc("Un bar familiar de desayunos ")
                .tags(Arrays.asList("Tostada de Jamón", "Triana", "Tapas", "Cruzcampo"))
                .image("https://lh3.googleusercontent.com/p/AF1QipN4xMh9rsormT41mxq-GHGE2S9x8nQ1RM1oTks=s680-w680-h510")
                .build()
        );
    }

        public Place add(Place place) {
            long id = counter.incrementAndGet();
            place.setId(id);
            places.put(id, place);
            return place;
        }

        public Optional<Place> get(Long id) {
            return Optional.ofNullable(places.get(id));
        }

        public List<Place> getAll() {
            return new ArrayList<>(places.values());
        }

        public Optional<Place> edit(Long id, Place updated) {
            return Optional.ofNullable(places.computeIfPresent(id, (k, v) -> {
                v.setName(updated.getName());
                v.setDesc(updated.getDesc());
                v.setCoords(updated.getCoords());
                v.setAddress(updated.getAddress());
                v.setImage(updated.getImage());
                return v;
            }));
        }

        public void delete(Long id) {
            places.remove(id);
        }
    }