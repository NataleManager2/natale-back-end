package com.natale.nataleManager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CURSO")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUR_ID")
    private Long curId;

    @Column(name = "CUR_DESCRIPCION")
    private String curDescripcion;

    @Column(name = "CUR_PRECIO")
    private Float curPrecio;

    @Column(name = "CUR_CANTIDAD_CLASES")
    private int curCantidadClases;

    @Column(name = "CUR_ACTIVO")
    private int curActivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUR_PRO_ID")
    private Profesor curProfesor;

    public Curso() {
    }

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }

    public String getCurDescripcion() {
        return curDescripcion;
    }

    public void setCurDescripcion(String curDescripcion) {
        this.curDescripcion = curDescripcion;
    }

    public Float getCurPrecio() {
        return curPrecio;
    }

    public void setCurPrecio(Float curPrecio) {
        this.curPrecio = curPrecio;
    }

    public int getCurCantidadClases() {
        return curCantidadClases;
    }

    public void setCurCantidadClases(int curCantidadClases) {
        this.curCantidadClases = curCantidadClases;
    }

    public int getCurActivo() {
        return curActivo;
    }

    public void setCurActivo(int curActivo) {
        this.curActivo = curActivo;
    }

    public Profesor getCurProfesor() {
        return curProfesor;
    }

    public void setCurProfesor(Profesor curProfesor) {
        this.curProfesor = curProfesor;
    }
}
