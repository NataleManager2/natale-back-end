package com.natale.nataleManager.service.impl;

import com.natale.nataleManager.model.Curso;
import com.natale.nataleManager.repository.CursoRepository;
import com.natale.nataleManager.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CursoServiceImpl implements CursoService {

    private static final Logger log = LoggerFactory.getLogger(CursoServiceImpl.class);

    private final CursoRepository cursoRepository;
    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso get(Long id) throws Exception {
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
    public Curso insert(Curso curso) throws Exception {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> getAll() throws Exception {
        return cursoRepository.findAllByCurActivo(true);
    }

    @Override
    public Curso update(Curso curso) throws Exception {
        if (curso.getNullAtributes().size() == 0) {
            return cursoRepository.save(curso);
        }
        log.error("El curso no se actualizo porque tenia los siguientes atributos nulos: "+ curso.getNullAtributes());
        return curso;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.delete(id);
    }


}
