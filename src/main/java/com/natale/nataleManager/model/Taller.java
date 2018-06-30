package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @Column(name = "TA_ID")
    private Long taId;

    @Column(name = "TA_NOMBRE")
    private String taNombre;

    @Column(name = "TA_DESCRIPCION")
    private String taDescripcion;

    @Column(name = "TA_PRECIO")
    private Float taPrecio;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "TA_FECHA")
    private Date taFecha;

    @Column(name = "TA_ACTIVO")
    private int taActivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TA_PRO_ID")
    private Profesor curProfesor;

    public Taller() {
    }

    public Long getTaId() {
        return taId;
    }

    public void setTaId(Long taId) {
        this.taId = taId;
    }

    public String getTaNombre() {
        return taNombre;
    }

    public void setTaNombre(String taNombre) {
        this.taNombre = taNombre;
    }

    public String getTaDescripcion() {
        return taDescripcion;
    }

    public void setTaDescripcion(String taDescripcion) {
        this.taDescripcion = taDescripcion;
    }

    public Float getTaPrecio() {
        return taPrecio;
    }

    public void setTaPrecio(Float taPrecio) {
        this.taPrecio = taPrecio;
    }

    public Date getTaFecha() {
        return taFecha;
    }

    public void setTaFecha(Date taFecha) {
        this.taFecha = taFecha;
    }

    public int getTaActivo() {
        return taActivo;
    }

    public void setTaActivo(int taActivo) {
        this.taActivo = taActivo;
    }

    public Profesor getCurProfesor() {
        return curProfesor;
    }

    public void setCurProfesor(Profesor curProfesor) {
        this.curProfesor = curProfesor;
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
