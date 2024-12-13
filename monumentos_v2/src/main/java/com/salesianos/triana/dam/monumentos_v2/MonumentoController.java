package com.salesianos.triana.dam.monumentos_v2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> getAll(
            @RequestParam(required = false, value = "ciudad", defaultValue = "") String ciudad,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        List<Monumento> result = monumentoRepository.query(ciudad, sortDirection);

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoRepository.add(monumento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long monumentoId) {

        return ResponseEntity.of(monumentoRepository
                .edit(monumentoId, monumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}