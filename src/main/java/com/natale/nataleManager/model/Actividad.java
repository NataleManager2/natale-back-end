package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

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

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="ACT_FECHA_DESDE")
    private Date actFechaDesde;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="ACT_FECHA_HASTA")
    private Date actFechaHasta;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="ACT_HORA_DESDE")
    private Time actHoraDesde;

    @JsonFormat(pattern = "hh:mm")
    @Column(name="ACT_HORA_HASTA")
    private Time actHoraHasta;

    @Column(name="ACT_BORRADA")
    private int actBorrada;

    @Column(name="ACT_PRECIO")
    private Float actPrecio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACT_PRO_ID")
    private Profesor actProfesor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACT_TIPO_ACT_ID")
    private TipoActividad actTipoActividad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ACT_SUBTIPO_ACT_ID")
    private SubtipoActividad actSubtipoActividad;

    public Actividad() {
    }

    public Actividad(String actNombre, String actDescripcion, Date actFechaDesde, Date actFechaHasta, Time actHoraDesde, Time actHoraHasta, TipoActividad actTipoActividad, SubtipoActividad actSubtipoActividad, int actBorrada, Float actPrecio, Profesor actProfesor) {
        this.actNombre = actNombre;
        this.actDescripcion = actDescripcion;
        this.actFechaDesde = actFechaDesde;
        this.actFechaHasta = actFechaHasta;
        this.actHoraDesde = actHoraDesde;
        this.actHoraHasta = actHoraHasta;
        this.actTipoActividad = actTipoActividad;
        this.actSubtipoActividad = actSubtipoActividad;
        this.actBorrada = actBorrada;
        this.actPrecio = actPrecio;
        this.actProfesor = actProfesor;
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

    public Date getActFechaDesde() {
        return actFechaDesde;
    }

    public void setActFechaDesde(Date actFechaDesde) {
        this.actFechaDesde = actFechaDesde;
    }

    public Date getActFechaHasta() {
        return actFechaHasta;
    }

    public void setActFechaHasta(Date actFechaHasta) {
        this.actFechaHasta = actFechaHasta;
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

    public TipoActividad getActTipoActividad() {
        return actTipoActividad;
    }

    public void setActTipoActividad(TipoActividad actTipoActividad) {
        this.actTipoActividad = actTipoActividad;
    }

    public SubtipoActividad getActSubtipoActividad() {
        return actSubtipoActividad;
    }

    public void setActSubtipoActividad(SubtipoActividad actSubtipoActividad) {
        this.actSubtipoActividad = actSubtipoActividad;
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
