package com.natale.nataleManager.model;

import com.natale.nataleManager.model.enums.EstadoProfesor;

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
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="DNI")
    private Long dni;

    @Column(name="NOMBRE", nullable = false)
    private String nombre;

    @Column(name="TELEFONO")
    private String telefono;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ESTADO")
    private EstadoProfesor estado;

    public Profesor() {
    }

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

    public EstadoProfesor getEstado() {
        return estado;
    }

    public void setEstado(EstadoProfesor estado) {
        this.estado = estado;
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
