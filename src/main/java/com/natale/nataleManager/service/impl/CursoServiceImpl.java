package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Curso;
import com.natale.nataleManager.repository.CursoRepository;
import com.natale.nataleManager.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoServiceImpl implements CursoService {

    private static final Logger log = LoggerFactory.getLogger(CursoServiceImpl.class);

    private final CursoRepository cursoRepository;
    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso get(Long id)  {
        Curso curso = new Curso();
        try{
            curso = cursoRepository.findOne(id);
            log.debug("findOne curso id: "+id+" succesful");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed findingOne curso with id: "+id);
        }
        return curso;
    }

    @Override
    public Curso insert(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Iterable<Curso> getAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso update(Curso curso) {
        try {
            if (curso.getNullAtributes().size() == 0) {
                return cursoRepository.save(curso);
            }
        } catch (IllegalAccessException e) {
            log.error("El curso no se actualizo porque tenia atributos nulos: "+e);
        }

        return curso;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.delete(id);
    }


}
