package com.example.ejerciciomonumentos.controller;

import com.example.ejerciciomonumentos.Monumento;
import com.example.ejerciciomonumentos.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
@Tag(name = "Monumentos", description = "Gestión de monumentos del mundo")
public class MonumentoController {

    private final MonumentoService monumentoService;

    @Operation(summary = "Obtener todos los monumentos", description = "Devuelve una lista de monumentos filtrados por ciudad y ordenados alfabéticamente.")
    @GetMapping
    public ResponseEntity<List<Monumento>> getAll(
            @RequestParam(required = false, value = "ciudad", defaultValue = "") String ciudad,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        List<Monumento> result = monumentoService.getAll(ciudad, sortDirection);

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Crear un nuevo monumento", description = "Añade un nuevo monumento al sistema.")
    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoService.create(monumento));
    }

    @Operation(summary = "Obtener un monumento por ID", description = "Devuelve el monumento asociado al ID especificado.")
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoService.getById(id));
    }

    @Operation(summary = "Editar un monumento existente", description = "Actualiza la información de un monumento existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long monumentoId) {

        return ResponseEntity.of(monumentoService.edit(monumentoId, monumento));
    }

    @Operation(summary = "Eliminar un monumento por ID", description = "Elimina el monumento asociado al ID especificado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
