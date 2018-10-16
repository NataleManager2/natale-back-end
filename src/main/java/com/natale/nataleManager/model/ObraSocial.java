package com.natale.nataleManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="OBRA_SOCIAL")
public class ObraSocial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="CENTRO_ATENCION")
    private String centroAtencion;

    public ObraSocial() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(String centroAtencion) {
        this.centroAtencion = centroAtencion;
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
