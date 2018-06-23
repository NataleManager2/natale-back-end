package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name="ACTIVIDAD")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ACT_ID")
    private Long actId;

    @Column(name="ACT_NOMBRE")
    private String actNombre;

    @Column(name="ACT_DESCRIPCION")
    private String actDescripcion;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="ACT_HORA_DESDE")
    private Time actHoraDesde;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="ACT_HORA_HASTA")
    private Time actHoraHasta;

    @Column(name="ACT_ACTIVA")
    private int actBorrada;

    @Column(name="ACT_PRECIO")
    private Float actPrecio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACT_PRO_ID")
    private Profesor actProfesor;

    public Actividad() {
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public Time getActHoraDesde() {
        return actHoraDesde;
    }

    public void setActHoraDesde(Time actHoraDesde) {
        this.actHoraDesde = actHoraDesde;
    }

    public Time getActHoraHasta() {
        return actHoraHasta;
    }

    public void setActHoraHasta(Time actHoraHasta) {
        this.actHoraHasta = actHoraHasta;
    }

    public int getActBorrada() {
        return actBorrada;
    }

    public void setActBorrada(int actBorrada) {
        this.actBorrada = actBorrada;
    }

    public Float getActPrecio() {
        return actPrecio;
    }

    public void setActPrecio(Float actPrecio) {
        this.actPrecio = actPrecio;
    }

    public Profesor getActProfesor() {
        return actProfesor;
    }

    public void setActProfesor(Profesor actProfesor) {
        this.actProfesor = actProfesor;
    }
}
