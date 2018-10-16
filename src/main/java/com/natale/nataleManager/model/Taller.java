package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.EstadoActividad;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TALLER")
public class Taller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Float precio;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "ESTADO")
    private EstadoActividad estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROFESOR")
    private Profesor profesor;

    public Taller() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
