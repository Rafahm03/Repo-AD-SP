package com.example.Ejerciciojpa.util;


import com.example.Ejerciciojpa.models.Categoria;
import com.example.Ejerciciojpa.models.Producto;
import com.example.Ejerciciojpa.repos.CategoriaRepository;
import com.example.Ejerciciojpa.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {

        Categoria c = categoriaRepository.getReferenceById(1L);
        Optional<Producto> op = productoRepository.findById(1L);


        //No usar el orElse, mejor devolver un optional

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                .categoria(c)
                .build();

        productoRepository.save(p);


        c.addProducto(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepository.saveAll(List.of(p, p2));

        System.out.println("Productos de la categoría");
        System.out.println(productoRepository.findAll());


        Categoria c2 = categoriaRepository.getReferenceById(2L);
    }

}