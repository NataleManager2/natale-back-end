package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="INSCRIPCION")
public class Inscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="INS_ID",nullable = false)
    private Long insId;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="INS_FECHA")
    private Date insFecha;

    @Column(name="INS_CREDITOS")
    private int insCreditos;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="INS_ULTIMA_ASISTENCIA")
    private Date insUltimaAsistencia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="INS_CLI_ID")
    private Cliente insCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="INS_ACT_ID")
    private Actividad insActividad;

    public Inscripcion() {
    }

    public Long getInsId() {
        return insId;
    }

    public void setInsId(Long insId) {
        this.insId = insId;
    }

    public Date getInsFecha() {
        return insFecha;
    }

    public void setInsFecha(Date insFecha) {
        this.insFecha = insFecha;
    }

    public Cliente getInsCliente() {
        return insCliente;
    }

    public void setInsCliente(Cliente insCliente) {
        this.insCliente = insCliente;
    }

    public Actividad getInsActividad() {
        return insActividad;
    }

    public void setInsActividad(Actividad insActividad) {
        this.insActividad = insActividad;
    }

    public int getInsCreditos() {
        return insCreditos;
    }

    public void setInsCreditos(int insCreditos) {
        this.insCreditos = insCreditos;
    }

    public Date getInsUltimaAsistencia() {
        return insUltimaAsistencia;
    }

    public void setInsUltimaAsistencia(Date insUltimaAsistencia) {
        this.insUltimaAsistencia = insUltimaAsistencia;
    }
}
