package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.CustomerState;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="dni",nullable = false)
    private Long dni;

    @Column(name="name")
    private String name;

    @Column(name="celphone")
    private String celphone;

    @Column(name="email")
    private String email;

    @Column(name="instagram")
    private String instagram;

    @Column(name="state")
    private CustomerState state;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="estimatedDueDate")
    private Date estimatedDueDate;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="lastMenstruationDate")
    private Date lastMenstruationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="healthInsurance")
    private HealthInsurance healthInsurance;

    @JsonFormat(timezone = "GMT-3",pattern = "dd/MM/yyyy")
    @Column(name="registerDate")
    private Date registerDate;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerState getState() {
        return state;
    }

    public void setState(CustomerState state) {
        this.state = state;
    }

    public Date getEstimatedDueDate() {
        return estimatedDueDate;
    }

    public void setEstimatedDueDate(Date estimatedDueDate) {
        this.estimatedDueDate = estimatedDueDate;
    }

    public Date getLastMenstruationDate() {
        return lastMenstruationDate;
    }

    public void setLastMenstruationDate(Date lastMenstruationDate) {
        this.lastMenstruationDate = lastMenstruationDate;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
