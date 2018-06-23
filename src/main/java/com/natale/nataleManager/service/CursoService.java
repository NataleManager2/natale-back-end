package com.natale.nataleManager.service;

import com.natale.nataleManager.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    Curso get(Long id) throws Exception;
    Curso insert(Curso curso) throws Exception;
    List<Curso> getAll() throws Exception;
    Curso update(Curso curso) throws Exception;
    void delete(Long id) throws Exception;
}
