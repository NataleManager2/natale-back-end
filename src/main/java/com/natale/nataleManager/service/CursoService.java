package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Curso;
import org.springframework.stereotype.Service;

@Service
public interface CursoService {
    Curso get(Long id);
    Curso insert(Curso curso);
    Iterable<Curso> getAll();
    Curso update(Curso curso);
    void delete(Curso curso);
}
