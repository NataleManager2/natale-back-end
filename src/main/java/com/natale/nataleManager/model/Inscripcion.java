package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.EstadoInscripcion;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="INSCRIPCION")
public class Inscripcion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",nullable = false)
    private Long id;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="FECHA",nullable = false)
    private Date fecha;

    @Column(name="CREDITOS",nullable = false)
    private int creditos;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="ULTIMA_ASISTENCIA",nullable = false)
    private Date ultimaAsistencia;

    @Column(name="ESTADO",nullable = false)
    private EstadoInscripcion estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CLIENTE")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACTIVIDAD")
    private Actividad actividad;

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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Date getUltimaAsistencia() {
        return ultimaAsistencia;
    }

    public void setUltimaAsistencia(Date ultimaAsistencia) {
        this.ultimaAsistencia = ultimaAsistencia;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
