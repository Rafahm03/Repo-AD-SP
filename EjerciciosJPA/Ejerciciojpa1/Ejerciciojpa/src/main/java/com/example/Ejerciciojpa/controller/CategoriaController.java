package com.example.Ejerciciojpa.controller;

import com.example.Ejerciciojpa.dto.EditCategoriaCmd;
import com.example.Ejerciciojpa.models.Categoria;
import com.example.Ejerciciojpa.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria nuevaCategoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(nuevaCategoria));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody EditCategoriaCmd editCategoriaCmd, @PathVariable Long id) {
        return categoriaService.edit(editCategoriaCmd, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}