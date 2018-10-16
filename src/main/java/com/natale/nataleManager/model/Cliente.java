package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.EstadoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="DNI",nullable = false)
    private Long dni;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="TEL")
    private String telefono;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ESTADO")
    private EstadoCliente estado;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="FECHA_PROBABLE_PARTO")
    private Date fechaProbableParto;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="FECHA_ULTIMA_MENSTRUACION")
    private Date fechaUltimaMenstruacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="OBRASOCIAL")
    private ObraSocial obraSocial;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="FECHA_REGISTRO")
    private Date fechaRegistro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }

    public Date getFechaProbableParto() {
        return fechaProbableParto;
    }

    public void setFechaProbableParto(Date fechaProbableParto) {
        this.fechaProbableParto = fechaProbableParto;
    }

    public Date getFechaUltimaMenstruacion() {
        return fechaUltimaMenstruacion;
    }

    public void setFechaUltimaMenstruacion(Date fechaUltimaMenstruacion) {
        this.fechaUltimaMenstruacion = fechaUltimaMenstruacion;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
