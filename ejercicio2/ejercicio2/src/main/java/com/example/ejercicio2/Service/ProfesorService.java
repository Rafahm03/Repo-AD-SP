package com.example.ejercicio2.Service;

import com.example.ejercicio2.Repository.ProfesorRepository;
import com.example.ejercicio2.model.Profesor;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll(){
        List<Profesor> result = profesorRepository.findAll();
        if(result.isEmpty())
            throw new EntityNotFoundException("aa");
            return result;
    }

}
