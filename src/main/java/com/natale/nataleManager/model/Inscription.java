package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natale.nataleManager.model.enums.InscriptionState;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="inscription")
public class Inscription implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="date",nullable = false)
    private Date fecha;

    @Column(name="credits",nullable = false)
    private int credits;

    @JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy hh:mm")
    @Column(name="lastAssistance",nullable = false)
    private Date lastAssistance;

    @Column(name="state",nullable = false)
    private InscriptionState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="activity")
    private Activity activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Date getLastAssistance() {
        return lastAssistance;
    }

    public void setLastAssistance(Date lastAssistance) {
        this.lastAssistance = lastAssistance;
    }

    public InscriptionState getState() {
        return state;
    }

    public void setState(InscriptionState state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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
