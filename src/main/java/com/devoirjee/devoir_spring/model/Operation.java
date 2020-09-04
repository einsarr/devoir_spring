package com.devoirjee.devoir_spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long operation_id;
    @Column(length = 9)
    private String code_envoi;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_envoi;
    @Column(length = 10)
    private String type_operation;
    private float montant_envoi;
    private float frais_envoi;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_retrait;
    @Column(columnDefinition = "float default 0")
    private float etat_traitement;

    @ManyToOne
    @JoinColumn(name = "client_env_id",nullable = false)
    private Client client_env;

    @ManyToOne
    @JoinColumn(name = "client_rec_id",nullable = true)
    private Client client_rec;

    @ManyToOne
    @JoinColumn(name = "caissier_env_id",nullable = false)
    private Users caissier_env;

    @ManyToOne
    @JoinColumn(name = "caissier_rec_id",nullable = true)
    private Users caissier_rec;

}
