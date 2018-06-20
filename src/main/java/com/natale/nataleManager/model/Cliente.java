package com.natale.nataleManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @JsonFormat(timezone = "GMT-3")
//    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name="CLI_OBRASOCIAL")
    private Date cliObraSocial;

    @JsonFormat(timezone = "GMT-3")
    @Column(name="CLI_FECHA_REGISTRO")
    private Date cliFechaRegistro;

    @JsonFormat(timezone = "GMT-3")
    @Column(name="CLI_FECHA_BAJA")
    private Date cliFechaBaja;

    @JsonFormat(timezone = "GMT-3")
    @Column(name="CLI_FECHA_MOD")
    private Date cliFechaMod;

}
