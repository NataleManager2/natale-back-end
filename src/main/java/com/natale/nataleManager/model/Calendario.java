package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CALENDARIO")
public class Calendario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAL_ID", nullable = false)
    private Long calId;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "CAL_FECHA")
    private Date calFecha;

    @Column(name = "CAL_MATERIAL")
    private byte[] calMaterial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAL_CUR_ID")
    private Curso calCurso;

    public Calendario() {
    }

    public Long getCalId() {
        return calId;
    }

    public void setCalId(Long calId) {
        this.calId = calId;
    }

    public Date getCalFecha() {
        return calFecha;
    }

    public void setCalFecha(Date calFecha) {
        this.calFecha = calFecha;
    }

    public byte[] getCalMaterial() {
        return calMaterial;
    }

    public void setCalMaterial(byte[] calMaterial) {
        this.calMaterial = calMaterial;
    }

    public Curso getCalCurso() {
        return calCurso;
    }

    public void setCalCurso(Curso calCurso) {
        this.calCurso = calCurso;
    }
}
