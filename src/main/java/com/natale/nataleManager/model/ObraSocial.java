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
@Table(name="OBRA_SOCIAL")
public class ObraSocial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="OS_ID")
    private Long osId;

    @Column(name="OS_NOMBRE")
    private String osNombre;

    @Column(name="OS_CENTRO_ATENCION")
    private String osCentroAtencion;

    public ObraSocial() {
    }

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public String getOsNombre() {
        return osNombre;
    }

    public void setOsNombre(String osNombre) {
        this.osNombre = osNombre;
    }

    public String getOsCentroAtencion() {
        return osCentroAtencion;
    }

    public void setOsCentroAtencion(String osCentroAtencion) {
        this.osCentroAtencion = osCentroAtencion;
    }
}
