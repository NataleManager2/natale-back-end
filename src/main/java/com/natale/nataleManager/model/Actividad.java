package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.EstadoActividad;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ACTIVIDAD")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="DESCRIPCION")
    private String descripcion;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="HORA_DESDE")
    private Time horaDesde;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="HORA_HASTA")
    private Time horaHasta;

    @Column(name="ESTADO")
    private EstadoActividad estado;

    @Column(name="PRECIO")
    private Float precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PROFESOR")
    private Profesor profesor;

    public Actividad() {
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

    public Time getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(Time horaDesde) {
        this.horaDesde = horaDesde;
    }

    public Time getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(Time horaHasta) {
        this.horaHasta = horaHasta;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
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
