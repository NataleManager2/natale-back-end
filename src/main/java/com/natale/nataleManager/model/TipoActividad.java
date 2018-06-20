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
@Table(name="TIPO_ACTIVIDAD")
public class TipoActividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TACT_ID")
    private Long tipoActividadId;

    @Column(name="TACT_NOMBRE")
    private String tipoActividadNombre;

    public TipoActividad() {
    }

    public Long getTipoActividadId() {
        return tipoActividadId;
    }

    public void setTipoActividadId(Long tipoActividadId) {
        this.tipoActividadId = tipoActividadId;
    }

    public String getTipoActividadNombre() {
        return tipoActividadNombre;
    }

    public void setTipoActividadNombre(String tipoActividadNombre) {
        this.tipoActividadNombre = tipoActividadNombre;
    }
}
