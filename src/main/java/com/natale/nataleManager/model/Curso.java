package com.natale.nataleManager.model;

import com.natale.nataleManager.model.enums.EstadoActividad;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CURSO")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "CANTIDAD_CLASES")
    private int cantidadClases;

    @Column(name = "ESTADO")
    private EstadoActividad estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROFESOR")
    private Profesor profesor;

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getCantidadClases() {
        return cantidadClases;
    }

    public void setCantidadClases(int cantidadClases) {
        this.cantidadClases = cantidadClases;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
