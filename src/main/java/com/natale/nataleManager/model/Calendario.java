package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="CALENDARIO")
public class Calendario  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "FECHA")
    private Date fecha;

    @Lob
    @Column(name = "MATERIAL")
    private byte[] material;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURSO")
    private Curso curso;

    public Calendario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public byte[] getMaterial() {
        return material;
    }

    public void setMaterial(byte[] material) {
        this.material = material;
    }

    public List<String> getNullAtributes() throws IllegalAccessException {
        List<String> atributosNulos = new ArrayList<>();
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this) == null) {
                atributosNulos.add(f.getName());
            }
        }
        return atributosNulos;
    }
}
