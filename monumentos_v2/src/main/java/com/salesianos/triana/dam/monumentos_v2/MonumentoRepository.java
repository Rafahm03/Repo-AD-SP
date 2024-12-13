package com.salesianos.triana.dam.monumentos_v2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monumento.builder().id(1L).nombreMonumento("Giralda").nombreCiudad("Sevilla").nombrePais("España").codPais("ES").latitud(37.386207).longitud(-5.99255572619863).imagen("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg").build());
        add(Monumento.builder().id(2L).nombreMonumento("Torre Eiffel").nombreCiudad("París").nombrePais("Francia").codPais("FR").latitud(48.8583701).longitud(2.2944813).imagen("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Eiffelturm.JPG/280px-Eiffelturm.JPG").build());
        add(Monumento.builder().id(3L).nombreMonumento("Burj Khalifa").nombreCiudad("Dubái").nombrePais("Emiratos Árabes").codPais("AE").latitud(25.197525).longitud(55.274288).imagen("https://i.blogs.es/adee70/burj-khalifa-22/1024_2000.jpeg").build());
        add(Monumento.builder().id(4L).nombreMonumento("La Estatua de la Libertad").nombreCiudad("New York").nombrePais("Estados Unidos").codPais("USA").latitud(40.6914).longitud(-74.0433).imagen("https://assets.cityexperiences.com/wp-content/uploads/2022/04/statue-hero-image-1024x690.jpg").build());
        add(Monumento.builder().id(5L).nombreMonumento("Palacio Vela de los Cobos").nombreCiudad("Jaén").nombrePais("España").codPais("ES").latitud(38.0133).longitud(3.3842).imagen("https://multimedia.andalucia.org/media/30C5694873514DF5BFE17164EAF1B940/img/510A13C93E4F46149134CBEEECD882D9/1592911957107Fachada_Palacio_Vela_de_los_Cobos8252328212905390779.jpg?responsive").build());

    }

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