package com.example.ejerciciomonumentos.service;

import com.example.ejerciciomonumentos.Monumento;
import com.example.ejerciciomonumentos.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    @Autowired
    private final MonumentoRepository monumentoRepository;

    public List<Monumento> getAll(String ciudad, String sortDirection) {
        return monumentoRepository.query(ciudad, sortDirection);
    }

    public Monumento create(Monumento monumento) {
        if (monumento.getId() <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        return monumentoRepository.add(monumento);
    }

    public Optional<Monumento> getById(Long id) {
        return monumentoRepository.get(id);
    }

    public Optional<Monumento> edit(Long id, Monumento newMonumento) {
        return monumentoRepository.edit(id, newMonumento);
    }

    public void delete(Long id) {
        monumentoRepository.delete(id);
    }
}
