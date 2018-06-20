package com.natale.nataleManager.model;

import javax.persistence.*;

@Entity
@Table(name="ACTIVIDAD")
public class Actividad {

    @Id
    @GeneratedValue
    @Column(name="ACT_ID")
    private Long actId;

    @Column(name="ACT_NOMBRE")
    private String actNombre;


}
