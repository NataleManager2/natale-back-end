package com.natale.nataleManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PROFESOR")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRO_ID", nullable = false)
    private Long proId;

    @Column(name="PRO_DNI")
    private Long proDni;

    @Column(name="PRO_NOMBRE", nullable = false)
    private String proNombre;

    @Column(name="PRO_TEL")
    private String proTel;

    @Column(name="PRO_EMAIL")
    private String proEmail;

    @Column(name="PRO_BORRADO")
    private int proBorrado;

    public Profesor() {
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Long getProDni() {
        return proDni;
    }

    public void setProDni(Long proDni) {
        this.proDni = proDni;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProTel() {
        return proTel;
    }

    public void setProTel(String proTel) {
        this.proTel = proTel;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    public int getProBorrado() {
        return proBorrado;
    }

    public void setProBorrado(int proBorrado) {
        this.proBorrado = proBorrado;
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
