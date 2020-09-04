package com.devoirjee.devoir_spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compte_id;
    private float montant;
    private float solde;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;


    @OneToMany(mappedBy = "compte")
    private List<AlimenterCompte> alimenterComptes;
/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "caissier_id", referencedColumnName = "caissier_id")
    private Users caissier;

    @OneToMany(mappedBy = "compte")
    private List<AlimenterCompte> alimenterComptes;*/



}
