package com.example.Ejerciciojpa.service;

import com.example.Ejerciciojpa.dto.EditCategoriaCmd;
import com.example.Ejerciciojpa.models.Categoria;
import com.example.Ejerciciojpa.repos.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay categorias con esos criterios de búsqueda");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }

    public Categoria save (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(EditCategoriaCmd editCategoriaCmd, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editCategoriaCmd.nombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));
    }
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}