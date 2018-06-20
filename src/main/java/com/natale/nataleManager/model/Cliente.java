package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLI_ID",nullable = false)
    private long cliId;

    @Column(name="CLI_DNI",nullable = false)
    private Long cliDni;

    @Column(name="CLI_NOMBRE")
    private String cliNombre;

    @Column(name="CLI_TEL")
    private String cliTel;

    @Column(name="CLI_EMAIL")
    private String cliEmail;

    @Column(name="CLI_BORRADO")
    private Boolean cliBorrado;

    @Column(name="CLI_FPP")
    private Date cliFpp;

    @Column(name="CLI_FUM")
    private Date cliFum;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CLI_OBRASOCIAL")
    private ObraSocial cliObraSocial;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="CLI_FECHA_REGISTRO")
    private Date cliFechaRegistro;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="CLI_FECHA_BAJA")
    private Date cliFechaBaja;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="CLI_FECHA_MOD")
    private Date cliFechaMod;


    public Cliente() {
    }

    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    public Long getCliDni() {
        return cliDni;
    }

    public void setCliDni(Long cliDni) {
        this.cliDni = cliDni;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliTel() {
        return cliTel;
    }

    public void setCliTel(String cliTel) {
        this.cliTel = cliTel;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Boolean getCliBorrado() {
        return cliBorrado;
    }

    public void setCliBorrado(Boolean cliBorrado) {
        this.cliBorrado = cliBorrado;
    }

    public Date getCliFpp() {
        return cliFpp;
    }

    public void setCliFpp(Date cliFpp) {
        this.cliFpp = cliFpp;
    }

    public Date getCliFum() {
        return cliFum;
    }

    public void setCliFum(Date cliFum) {
        this.cliFum = cliFum;
    }

    public ObraSocial getCliObraSocial() {
        return cliObraSocial;
    }

    public void setCliObraSocial(ObraSocial cliObraSocial) {
        this.cliObraSocial = cliObraSocial;
    }

    public Date getCliFechaRegistro() {
        return cliFechaRegistro;
    }

    public void setCliFechaRegistro(Date cliFechaRegistro) {
        this.cliFechaRegistro = cliFechaRegistro;
    }

    public Date getCliFechaBaja() {
        return cliFechaBaja;
    }

    public void setCliFechaBaja(Date cliFechaBaja) {
        this.cliFechaBaja = cliFechaBaja;
    }

    public Date getCliFechaMod() {
        return cliFechaMod;
    }

    public void setCliFechaMod(Date cliFechaMod) {
        this.cliFechaMod = cliFechaMod;
    }
}
