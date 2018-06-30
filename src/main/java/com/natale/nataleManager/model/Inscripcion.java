package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

@Entity
@Table(name="INSCRIPCION")
public class Inscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="INS_ID",nullable = false)
    private Long insId;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="INS_FECHA",nullable = false)
    private Date insFecha;

    @Column(name="INS_CREDITOS",nullable = false)
    private int insCreditos;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="INS_ULTIMA_ASISTENCIA",nullable = false)
    private Date insUltimaAsistencia;

    @Column(name="INS_PENDIENTE_APROBACION",nullable = false)
    private Boolean isPendienteAprobacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="INS_CLI_ID",nullable = false)
    private Cliente insCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="INS_ACT_ID",nullable = false)
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

    public Boolean getPendienteAprobacion() { return isPendienteAprobacion; }

    public void setPendienteAprobacion(Boolean pendienteAprovacion) { isPendienteAprobacion = pendienteAprovacion; }

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
