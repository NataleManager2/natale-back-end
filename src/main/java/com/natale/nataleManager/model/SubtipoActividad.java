package com.natale.nataleManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@NoArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name="SUBTIPO_ACTIVIDAD")
public class SubtipoActividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STACT_ID")
    private Long subtipoActividadId;

    @Column(name="STACT_NOMBRE")
    private String subtipoActividadNombre;

    @Column(name="STACT_BORRADA")
    private int subtipoActividadBorrada;

    @Column(name="STACT_CREDITOS")
    private int subtipoActividadCreditos;

    public SubtipoActividad() {
    }

    public Long getSubtipoActividadId() {
        return subtipoActividadId;
    }

    public void setSubtipoActividadId(Long subtipoActividadId) {
        this.subtipoActividadId = subtipoActividadId;
    }

    public String getSubtipoActividadNombre() {
        return subtipoActividadNombre;
    }

    public void setSubtipoActividadNombre(String subtipoActividadNombre) {
        this.subtipoActividadNombre = subtipoActividadNombre;
    }

    public int getSubtipoActividadBorrada() {
        return subtipoActividadBorrada;
    }

    public void setSubtipoActividadBorrada(int subtipoActividadBorrada) {
        this.subtipoActividadBorrada = subtipoActividadBorrada;
    }

    public int getSubtipoActividadCreditos() {
        return subtipoActividadCreditos;
    }

    public void setSubtipoActividadCreditos(int subtipoActividadCreditos) {
        this.subtipoActividadCreditos = subtipoActividadCreditos;
    }
}
