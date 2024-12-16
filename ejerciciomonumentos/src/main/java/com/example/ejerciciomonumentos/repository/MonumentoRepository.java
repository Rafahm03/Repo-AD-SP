package com.example.ejerciciomonumentos.repository;

import com.example.ejerciciomonumentos.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();



    public Monumento add(Monumento monumento) {
        monumentos.put(monumento.getId(), monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento newMonumento) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setNombreMonumento(newMonumento.getNombreMonumento());
            v.setNombreCiudad(newMonumento.getNombreCiudad());
            v.setNombrePais(newMonumento.getNombrePais());
            v.setCodPais(newMonumento.getCodPais());
            v.setLatitud(newMonumento.getLatitud());
            v.setLongitud(newMonumento.getLongitud());
            v.setImagen(newMonumento.getImagen());
            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> query(String ciudad, String sortDirection) {
        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if (ciudad == null || ciudad.isEmpty()) {
            result = data;
        } else {
            result = data.stream()
                    .filter(m -> m.getNombreCiudad().equalsIgnoreCase(ciudad))
                    .collect(Collectors.toList());
        }

        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monumento::getNombreMonumento));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monumento::getNombreMonumento).reversed());
        }

        return Collections.unmodifiableList(result);
    }
}
